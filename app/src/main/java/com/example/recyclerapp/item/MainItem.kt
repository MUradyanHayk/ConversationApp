package com.example.recyclerapp.item

import android.content.Context
import android.graphics.*
import android.text.TextPaint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.recyclerapp.R
import com.example.recyclerapp.model.MainModel
import com.example.recyclerapp.utils.ScreenResolutionManager
import com.example.recyclerapp.utils.dp
import com.example.recyclerapp.utils.setPaddings

class MainItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    val bgPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    var rectF = RectF()

    private var textView: TextView? = null
    private var textViewParams: LayoutParams? = null

    init {
        isClickable = true
        background = ContextCompat.getDrawable(context, android.R.drawable.list_selector_background)
//        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        this.setPaddings(16.dp)

//        this.layoutParams = params
        createTextView()


        bgPaint.color = ContextCompat.getColor(context, R.color.green)
    }

    private fun createTextView() {
        textView = TextView(context)
        textView?.text = "skdskdsd schak ZNN JN JN"
        textView?.setTextColor(ContextCompat.getColor(context, R.color.black))
        textView?.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
        textView?.typeface = Typeface.DEFAULT_BOLD
        textViewParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView?.layoutParams = textViewParams
        textView?.isSingleLine = false
        textView?.setEms(15)
        addView(textView)
    }
    val textViewBounds = Rect()

//    val textViewPaint: TextPaint by lazy {
//        val p = TextPaint(Paint.ANTI_ALIAS_FLAG)
//        p.density = resources.displayMetrics.density
//        p.color = ContextCompat.getColor(context, R.color.black)
//        p.textSize = 18f
//        p.drawableState = drawableState
//        p.isFakeBoldText = true
//        p.textSkewX = 0f
//        return@lazy p
//    }
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val w = MeasureSpec.getSize(ScreenResolutionManager.getScreenWidth(context))
        val h = MeasureSpec.getSize(100.dp)
        textView?.paint?.getTextBounds(textView?.text?.toString() ?: "", 0, textView?.text?.length ?: 0, textViewBounds)
//        textViewPaint.getTextBounds(textView?.text?.toString() ?: "", 0, textView?.text?.length ?: 0, textViewBounds)
        textView?.measure(100.dp, textViewBounds.height() + 6.dp)
        setMeasuredDimension(w, h)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    fun configure(model: MainModel) {
        var gravity: Int? = if (model.isInComing) {
            Gravity.END
        } else {
            Gravity.START
        }
//        gravity = gravity!! or Gravity.CENTER_VERTICAL

        textView?.text = model.name

        textViewParams?.gravity = gravity
    }

    override fun onDraw(canvas: Canvas?) {

        super.onDraw(canvas)
    }
}