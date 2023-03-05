package com.yf.afreesvgvts.example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yf.afreesvg.SVGToAndroidCanvas
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import javax.xml.transform.TransformerException

class MainActivity : AppCompatActivity() {
    private lateinit var customView: CustomView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_view)
        customView = findViewById(R.id.custom)
        customView.setOnClickListener { view ->
            val canvas =
                SVGToAndroidCanvas(
                    customView.getWidth().toDouble(),
                    customView.getHeight().toDouble()
                )
            customView.draw(canvas)
            val file = File(cacheDir, "custom.svg")
            try {
                canvas.svgCanvas.writeSVGXMLToStream(FileOutputStream(file))
            } catch (e: TransformerException) {
                e.printStackTrace()
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}