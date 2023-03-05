/*
 * Copyright (c) 2023.  by iffly Limited.  All rights reserved.
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 */

package com.yf.afreesvg

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RectF
import android.os.Build

private fun Paint.toSVGPaint(): SVGPaint = SVGPaint(flags).also {
    it.fillColor = color
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        it.wordSpacing = wordSpacing
    }
}

class SVGToAndroidCanvas : Canvas {
    public val svgCanvas: SVGCanvas

    constructor(width: Double, height: Double) {
        svgCanvas = SVGCanvas(width, height)
    }

    constructor(svgCanvas: SVGCanvas) {
        this.svgCanvas = svgCanvas;
    }

    override fun drawOval(oval: RectF, paint: Paint) {
        svgCanvas.drawOval(oval, paint.toSVGPaint())
    }

    override fun drawOval(left: Float, top: Float, right: Float, bottom: Float, paint: Paint) {
        svgCanvas.drawOval(RectF(left, top, right, bottom), paint.toSVGPaint())
    }


}