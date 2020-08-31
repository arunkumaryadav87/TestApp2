package com.aruun.testapp2

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.Log
import android.view.View

class CustomView : View {
    private var chart1: Chart? = null
    private var chart2: Chart? = null
    private var overlayChart: Chart? = null

    constructor(context: Context?) : super(context) {
        init(null)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init(null)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(null)
    }

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        init(null)
    }

    private fun init(set: AttributeSet?) {
        Log.d("init", "This method will be used for initialising in different constructor called")
    }

    fun setChart(chart1: Chart, chart2: Chart, overlayChart: Chart) {
        this.chart1 = chart1
        this.chart2 = chart2
        this.overlayChart = overlayChart
    }

    fun swapColor(chart1Color: Int, chart2Color: Int) {
        chart1!!.rgbColor = if (chart1!!.rgbColor == chart1Color) chart2Color else chart1Color
        chart2!!.rgbColor = if (chart2!!.rgbColor == chart1Color) chart2Color else chart1Color
        postInvalidate()
    }

    override fun onDraw(canvas: Canvas) {
        chart1?.getRect()?.let { canvas.drawRect(it, chart1!!.getPaint()) }
        chart2?.getRect()?.let { canvas.drawRect(it, chart2!!.getPaint()) }
        overlayChart?.getRect()?.let { canvas.drawRect(it, overlayChart!!.getPaint()) }
    }

    companion object {
        private const val SQUARE_SIZE_DEF = 200
    }
}