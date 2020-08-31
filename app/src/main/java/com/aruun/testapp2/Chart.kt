package com.aruun.testapp2

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect

class Chart(var topLeft: Point, var bottomRight: Point, var rgbColor: Int) {

    private var mRect: Rect? = null

    fun getRect() : Rect? {
        mRect = Rect()
        mRect!!.left = topLeft.axisX
        mRect!!.top = topLeft.axisY
        mRect!!.right = bottomRight.axisX
        mRect!!.bottom = bottomRight.axisY

        return mRect
    }

    fun isOverLapping(other: Chart): Boolean {
        return (topLeft.axisX > other.bottomRight.axisX // R1 is right to R2
                || bottomRight.axisX < other.topLeft.axisX // R1 is left to R2
                || topLeft.axisY < other.bottomRight.axisY // R1 is above R2
                || bottomRight.axisY > other.topLeft.axisY
                )
    }

    fun getPaint(): Paint {
        val mPaintSquare = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaintSquare.color = rgbColor
        return mPaintSquare
    }
}