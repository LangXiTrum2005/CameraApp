package com.photolab.vintage.activity

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DegreeSeekBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    interface ScrollingListener {
        fun onScrollStart()
        fun onScroll(degrees: Int)
        fun onScrollEnd()
    }

    private var mCurrentDegrees = 0
    private var mMinDegrees = -45
    private var mMaxDegrees = 45
    private var mScrollingListener: ScrollingListener? = null
    private var mLastTouchedX = 0f

    private val mPointPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mTextPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val mIndicatorPath = Path()

    init {
        mPointPaint.color = Color.WHITE
        mTextPaint.color = Color.WHITE
        mTextPaint.textSize = 36f
        mTextPaint.textAlign = Paint.Align.CENTER
    }

    fun setDegreeRange(minDegrees: Int, maxDegrees: Int) {
        this.mMinDegrees = minDegrees
        this.mMaxDegrees = maxDegrees
    }

    fun setCurrentDegrees(degrees: Int) {
        this.mCurrentDegrees = degrees.coerceIn(mMinDegrees, mMaxDegrees)
        invalidate()
    }

    fun getCurrentDegrees(): Int = mCurrentDegrees

    fun setScrollingListener(listener: ScrollingListener?) {
        this.mScrollingListener = listener
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val cx = width / 2f
        val cy = height / 2f

        canvas.drawText("$mCurrentDegrees°", cx, cy + 12f, mTextPaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                mLastTouchedX = event.x
                mScrollingListener?.onScrollStart()
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                val deltaX = event.x - mLastTouchedX
                mLastTouchedX = event.x
                val degreeDelta = (deltaX / 10f).toInt()
                if (degreeDelta != 0) {
                    mCurrentDegrees = (mCurrentDegrees + degreeDelta).coerceIn(mMinDegrees, mMaxDegrees)
                    invalidate()
                    mScrollingListener?.onScroll(mCurrentDegrees)
                }
                return true
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                mScrollingListener?.onScrollEnd()
                return true
            }
        }
        return super.onTouchEvent(event)
    }
}
