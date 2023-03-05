package com.yf.afreesvgvts.example

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CustomView(context: Context, attributeSet: AttributeSet) : View(context, attributeSet) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.RED
        val rect = RectF(100f, 100f, 200f, 200f)
        canvas?.let { canvas ->
            canvas.drawOval(rect, paint)


        }
    }
}