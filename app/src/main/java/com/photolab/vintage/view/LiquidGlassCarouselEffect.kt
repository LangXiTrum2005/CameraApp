package com.photolab.vintage.view

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.abs

/**
 * Presentation-only treatment for horizontally scrolling controls.  It changes
 * only the rendered transform of visible children; adapter state and touch
 * handling remain untouched.
 */
class LiquidGlassCarouselEffect(
    private val minScale: Float = 0.88f,
    private val edgeAlpha: Float = 0.64f
) : RecyclerView.OnScrollListener() {

    private val sheen = Paint(Paint.ANTI_ALIAS_FLAG)

    private val reflection = object : RecyclerView.ItemDecoration() {
        override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
            for (index in 0 until parent.childCount) {
                val child = parent.getChildAt(index)
                val intensity = ((child.scaleX - minScale) / (1f - minScale)).coerceIn(0f, 1f)
                if (intensity <= 0f) continue

                sheen.shader = LinearGradient(
                    0f,
                    child.top.toFloat(),
                    0f,
                    child.top + child.height * 0.48f,
                    intArrayOf(
                        Color.argb((60 * intensity).toInt(), 255, 255, 255),
                        0x00FFFFFF
                    ),
                    null,
                    Shader.TileMode.CLAMP
                )
                canvas.save()
                canvas.clipRect(child.left, child.top, child.right, child.bottom)
                canvas.drawRect(
                    child.left.toFloat(),
                    child.top.toFloat(),
                    child.right.toFloat(),
                    child.bottom.toFloat(),
                    sheen
                )
                canvas.restore()
            }
            sheen.shader = null
        }
    }

    fun attachTo(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(this)
        recyclerView.addItemDecoration(reflection)
        recyclerView.addOnLayoutChangeListener { _, _, _, _, _, _, _, _, _ -> updateChildren(recyclerView) }
        recyclerView.post { updateChildren(recyclerView) }
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        updateChildren(recyclerView)
    }

    private fun updateChildren(recyclerView: RecyclerView) {
        if (recyclerView.width == 0) return
        val focalPoint = recyclerView.paddingLeft +
            (recyclerView.width - recyclerView.paddingLeft - recyclerView.paddingRight) / 2f
        val maxDistance = recyclerView.width / 2f

        for (index in 0 until recyclerView.childCount) {
            val child = recyclerView.getChildAt(index)
            val distance = abs((child.left + child.right) / 2f - focalPoint)
            val progress = (distance / maxDistance).coerceIn(0f, 1f)
            val focus = 1f - progress
            val scale = minScale + (1f - minScale) * focus

            child.scaleX = scale
            child.scaleY = scale
            child.alpha = edgeAlpha + (1f - edgeAlpha) * focus
            child.translationY = (1f - focus) * 7f * recyclerView.resources.displayMetrics.density
            child.translationZ = focus * 8f * recyclerView.resources.displayMetrics.density
        }
        recyclerView.invalidateItemDecorations()
    }
}
