package com.example.recyclerapp.item

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.recyclerapp.R
import com.example.recyclerapp.utils.ScreenResolutionManager
import com.example.recyclerapp.utils.dp

class CustomTextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

  private var customText:Custom? = null


    init {
        createCustomText()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        customText?.measure()
        val w = MeasureSpec.getSize(ScreenResolutionManager.getScreenWidth(context))
        val h = MeasureSpec.getSize(300.dp)
        setMeasuredDimension(w, customText?.height ?: 0)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        customText?.layout(0, 0, customText?.width ?: 0, customText?.height ?: 0)
    }

    private fun createCustomText() {
        customText = Custom(context)
        customText?.text = "sdfkjdkfmdfkl msdlk m"
        customText?.textColor = ContextCompat.getColor(context, R.color.black)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        customText?.draw(canvas)

    }
}