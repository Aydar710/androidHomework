package com.example.aydar.editingusersprofile

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View

class BarChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private var chartData = mutableListOf<Float>()

    private val barPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = context.resources.getColor(R.color.colorAccent)
    }
    private val axisPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color = context.resources.getColor(R.color.grid_color)
        strokeWidth = 1f.convertToPx()
    }

    private var columnSpacing: Float = 0f
    private var padding = 16f.convertToPx()

    init {
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.BarChartView)
        columnSpacing = attributes.getDimension(R.styleable.BarChartView_spacing, 0f).convertToPx()
        val chartColor = attributes.getColor(R.styleable.BarChartView_chartColor, context.resources.getColor(R.color.colorAccent))
        barPaint.color = chartColor
        attributes.recycle()
    }

    override fun onDraw(canvas: Canvas?) {
        val gridLeft = padding
        val gridBottom = height - padding
        val gridTop = padding
        val gridRight = width - padding

        canvas?.drawLine(gridLeft, gridBottom, gridRight + columnSpacing, gridBottom, axisPaint)
        canvas?.drawLine(gridLeft, gridBottom, gridLeft, gridTop, axisPaint)

        val totalColumnSpacing = columnSpacing * (chartData.size - 1)
        val columnWidth = (gridRight - gridLeft - totalColumnSpacing) / chartData.size
        var columnLeft = gridLeft + columnSpacing
        var columnRight = columnLeft + columnWidth
        chartData.forEach {
            val top = gridTop + height * (1f - it)
            canvas?.drawRect(columnLeft, top, columnRight, gridBottom, barPaint)
            columnLeft = columnRight + columnSpacing
            columnRight = columnLeft + columnWidth
        }
    }

    private fun Number.convertToPx() = TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_DIP, this.toFloat(), context.resources.displayMetrics)

    fun setData(list : List<Float>){
        chartData.clear()
        chartData.addAll(list)
        invalidate()
    }
}