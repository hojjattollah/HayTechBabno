package com.example.babnowidgets.button

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class RecordButton : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)


    var mode: Mode = Mode.Ready
        set(value) {
            field = value
            invalidate()
        }

    private var cx: Float = 0f
    private var cy: Float = 0f
    private var radius: Float = 0f

    private val arcRect = RectF()
    private val recordRect = RectF()
    private val textBounds = Rect()

    var progress = 0
        set(value) {
            field = value
            invalidate()
        }

    private val radiusDiff = dpToPx(10).toFloat()
    private var recordRadius: Float = 0f

    private val outerPaint = Paint()
    private val innerPaint = Paint()
    private val recordPaint = Paint()
    private val textPaint = Paint()
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        outerPaint.color = Color.parseColor("#4F34F3")
        outerPaint.strokeWidth = radiusDiff
        outerPaint.style = Paint.Style.FILL
        outerPaint.isAntiAlias = true

        innerPaint.color = Color.YELLOW
        innerPaint.isAntiAlias = true

        recordPaint.color = Color.RED

        textPaint.color = Color.BLACK
        textPaint.textAlign = Paint.Align.CENTER
        textPaint.textSize = dpToPx(14).toFloat()

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        if (measuredHeight > 0 && measuredWidth > 0) {
            cx = measuredWidth / 2f
            cy = measuredHeight / 2f
            radius = Math.min(measuredHeight, measuredWidth) / 2 * 0.95f - paddingBottom
            recordRadius = radius / 4f
            recordRect.set(cx - recordRadius, cy - recordRadius, cx + recordRadius, cy + recordRadius)
            arcRect.set(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat())
        }
    }

    override fun onDraw(canvas: Canvas) {
        when (mode) {
            Mode.Loading -> {
                canvas.drawArc(arcRect, 0f, 360f * (progress.toFloat() / 100f), true, outerPaint)
                canvas.drawCircle(cx, cy, radius - radiusDiff, innerPaint)
                val text = "$progress%"
                textPaint.getTextBounds(text, 0, text.length, textBounds)
                canvas.drawText(text, cx, cy - textBounds.exactCenterY(), textPaint)
            }
            Mode.Ready -> {
                canvas.drawCircle(cx, cy, radius, outerPaint)
                canvas.drawCircle(cx, cy, radius - radiusDiff, innerPaint)
                canvas.drawCircle(cx, cy, recordRadius, recordPaint)
            }
            Mode.Recording -> {
                canvas.drawCircle(cx, cy, radius, outerPaint)
                canvas.drawCircle(cx, cy, radius - radiusDiff, innerPaint)
                canvas.drawRect(recordRect, recordPaint)
            }
            Mode.Idle -> {
                canvas.drawCircle(cx, cy, radius, outerPaint)
                canvas.drawCircle(cx, cy, radius - radiusDiff, innerPaint)
            }
        }
    }

    enum class Mode {
        Idle, Ready, Recording, Loading
    }

    fun dpToPx(dp: Int) = (dp * resources.displayMetrics.density).toInt()
}