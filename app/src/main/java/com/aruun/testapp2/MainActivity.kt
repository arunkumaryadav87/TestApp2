package com.aruun.testapp2

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var chart1Color: Int? = Color.rgb(0, 128, 0)
    var chart2Color: Int? = Color.rgb(255, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chart1 = Chart(Point(50, 50), Point(250, 250), chart1Color!!)
        val chart2 = Chart(Point(150, 150), Point(350, 350), chart2Color!!)

        val overlayChart = if (chart1.isOverLapping(chart2)) Chart(
            chart2.topLeft,
            chart1.bottomRight,
            Color.rgb((0 + 255) / 2, (128 + 0) / 2, 0)
        ) else null

        customView.setChart(chart1, chart2, overlayChart!!)

        btnSwapColor.setOnClickListener {
            customView.swapColor(chart1Color!!, chart2Color!!)
        }
    }
}