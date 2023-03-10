package com.example.recyclerapp.item

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerapp.utils.dp
import com.example.recyclerapp.utils.setPaddings

class MainAdapterItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var textView: TextView? = null
    private val CHECKED_IMAGE_VIEW_SIZE = 26.dp

    var _checkedImageView: ImageView? = null
    var checkedImageView: ImageView? = null
//        get() {
//            if (isInSelectedMode()) {
////                field.visibility = View.VISIBLE
//                createImageView()
//            } else {
////                field.visibility = View.GONE
//                removeImageView()
//            }
//
//        }

    init {
        textView?.setPaddings(16.dp)
        createTextView()
    }


    fun isInSelectedMode(): Boolean {
//                return mSelectionManager != null && getSelectionManager().selectedMessages.isNotEmpty()
        return true
    }

    private fun createTextView() {
        textView = TextView(context)
        textView?.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18f)
        textView?.typeface = Typeface.DEFAULT_BOLD
        textView?.gravity = Gravity.START or Gravity.CENTER_VERTICAL
        val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
        textView?.layoutParams = params
        addView(textView)
    }
}