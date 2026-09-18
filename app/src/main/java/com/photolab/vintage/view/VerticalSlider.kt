package com.photolab.vintage.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class VerticalSlider @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    interface OnProgressChangeListener {
        fun onProgress(progress: Float)
        fun onFinish()
    }

    private var mProgress = 0.0f
    private var mListener: OnProgressChangeListener? = null
    private val mTrackBgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mTrackFgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mThumbFgPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mTrackRect = RectF()

    private var mTrackBgThickness = dpToPx(4f)
    private var mTrackFgThickness = dpToPx(2f)
    private var mThumbRadius = dpToPx(6f)

    init {
        mTrackBgPaint.color = Color.parseColor("#dddfeb")
        mTrackFgPaint.color = Color.parseColor("#7da1ae")
        mThumbFgPaint.color = Color.parseColor("#7da1ae")
    }

    fun setProgress(progress: Float) {
        this.mProgress = progress.coerceIn(0f, 1f)
        invalidate()
    }

    fun getProgress(): Float = mProgress

    fun setOnProgressChangeListener(listener: OnProgressChangeListener?) {
        this.mListener = listener
    }

    fun setThumbColor(color: Int) {
        mThumbFgPaint.color = color
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val width = width.toFloat()
        val height = height.toFloat()

        val centerX = width / 2f
        val top = mThumbRadius.toFloat()
        val bottom = height - mThumbRadius.toFloat()

        // Draw track bg
        mTrackRect.set(centerX - mTrackBgThickness / 2f, top, centerX + mTrackBgThickness / 2f, bottom)
        canvas.drawRoundRect(mTrackRect, mTrackBgThickness / 2f, mTrackBgThickness / 2f, mTrackBgPaint)

        // Draw track fg
        val currentY = bottom - (bottom - top) * mProgress
        mTrackRect.set(centerX - mTrackFgThickness / 2f, currentY, centerX + mTrackFgThickness / 2f, bottom)
        canvas.drawRoundRect(mTrackRect, mTrackFgThickness / 2f, mTrackFgThickness / 2f, mTrackFgPaint)

        // Draw thumb
        canvas.drawCircle(centerX, currentY, mThumbRadius.toFloat(), mThumbFgPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val top = mThumbRadius.toFloat()
        val bottom = height - mThumbRadius.toFloat()
        val totalHeight = bottom - top

        when (event.action) {
            MotionEvent.ACTION_DOWN, MotionEvent.ACTION_MOVE -> {
                val touchY = event.y.coerceIn(top, bottom)
                mProgress = (bottom - touchY) / totalHeight
                invalidate()
                mListener?.onProgress(mProgress)
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                mListener?.onFinish()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    private fun dpToPx(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
    }
}
