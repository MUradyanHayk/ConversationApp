package com.example.recyclerapp.item

import android.content.Context
import android.graphics.*
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.view.Gravity
import androidx.core.content.ContextCompat
import com.example.recyclerapp.R
import com.example.recyclerapp.utils.dp
import kotlin.math.ceil
import kotlin.math.roundToInt

abstract class ZBaseCustomText(private val context: Context) {
    var gravity: Int = Gravity.NO_GRAVITY
    var paint: TextPaint = createPaintGroupMessageItem()
    var paddingLeft: Int = 0
    var paddingTop: Int = 0
    var paddingRight: Int = 0
    var paddingBottom: Int = 0

    var width = 0
    var height = 0
    var textBoundsRect: Rect = Rect()
    var isHidden: Boolean = false
    var typeface: Typeface
        get() {
            return paint.typeface
        }
        set(value) {
            paint.typeface = value
        }
    var textSize: Float
        set(value) {
//        paint.textSize = value * MainApplication.getMainContext().resources.displayMetrics.scaledDensity
            paint.textSize = value
        }
        get() {
            return paint.textSize
        }

//    var wrtfg = Rect()
//
//    var textHeight = 0f
//    get() {
//        val texts = text.split("\n".toRegex()).toTypedArray()
//
//        paint.getTextBounds(texts[0], 0, texts[0].length, wrtfg)
//
//        var h = 18.dp
//        for (text in texts) {
//            paint.getTextBounds(text, 0, text.length, wrtfg)
//            h += wrtfg.height() + 18.dp
//        }
//        return h.toFloat()
//    }

    private var lastText = ""
    var text: String = ""
        set(value) {
//            if (value != field) {
            paint.getTextBounds(value, 0, value.length, textBoundsRect)
//            }

            field = value
        }
    var textColor: Int = ContextCompat.getColor(context, R.color.white)
        set(value) {
            field = value
            paint.color = field
        }

    var background: Drawable? = null

    var ems: Int = 0
        set(value) {
            field = value
            text = calculateEms(value, text)
        }

    var lastLineEms: Int = -1
        set(value) {
            field = value
//            text = calculateEms(value, text)
        }

    val textLineCount: Int
        get() {
            val texts = text.split("\n".toRegex()).toTypedArray()
            return texts.size + 1
        }
    var frame: RectF = RectF()

    private fun calculateEms(ems: Int, text: String): String {
        var _ems = ems

        if (_ems > 0 && text != "") {
            var wordsCount = 0
            var lastSpacePosition = 0
            var sentence = ""

            for (i in text.indices) {
                if (lastLineEms != -1 && i == text.length - 1) {
                    _ems = lastLineEms
                }
                wordsCount++
                if (text[i] == '\n') {
                    wordsCount = 0
                }
                if (text[i] == ' ') {
                    lastSpacePosition = i
                }
                if (wordsCount > _ems) {
                    if (text[i] == ' ') {
                        sentence += '\n'
                        lastSpacePosition = i
                        wordsCount = 0
                    } else {
                        sentence += text[i]
                        sentence = replaceChar(sentence, '\n', lastSpacePosition)!!
                        wordsCount = sentence.length - lastSpacePosition
                        if (wordsCount < 0) {
                            wordsCount = 0
                        }
                    }
                    continue
                }
                sentence += text[i]
            }
            return sentence
        }
        return text
    }

    private fun replaceChar(str: String, ch: Char, position: Int): String? {
        return if (position < str.length) {
            str.substring(0, position) + ch + str.substring(position + 1)
        } else {
            str.substring(0, position) + ch
        }
    }

    private fun createPaintGroupMessageItem(): TextPaint {
        val paint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = 10f.dp
        paint.color = ContextCompat.getColor(context, R.color.white)
//        paint.typeface = Typeface.DEFAULT_BOLD
        return paint
    }

    fun setPadding(paddingLeft: Int, paddingTop: Int, paddingRight: Int, paddingBottom: Int) {
        this.paddingLeft = paddingLeft
        this.paddingTop = paddingTop
        this.paddingRight = paddingRight
        this.paddingBottom = paddingBottom
    }

    fun setPaddings(padding: Int) {
        this.paddingLeft = padding
        this.paddingTop = padding
        this.paddingRight = padding
        this.paddingBottom = padding
    }

    fun measure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        paint.getTextBounds(text, 0, text.length, textBoundsRect)
        this.width = textBoundsRect.width() + 16.dp
        this.height = textBoundsRect.height() + 9.dp
    }


    fun measure() {
        paint.getTextBounds(text, 0, text.length, textBoundsRect)
//        this.width = textBoundsRect.width() + 16.dp
//        this.height = textBoundsRect.height() + 9.dp

        text = calculateEms(ems, text)


//        val size = if (text.length <= ems) 1 else (text.length / ems) + 1
        this.width = getMaxTextWidth(paint, text).roundToInt() + paddingLeft + paddingRight
        val size = text.split("\n").size
        this.height = (size * (textBoundsRect.height() /*+ if (size > 1) 2f.dp else 1f*//*+ 6.dp*/) /*+ 3.dp*/ + paddingTop + paddingBottom)

    }

    fun layout(left: Int, top: Int, right: Int, bottom: Int) {
        frame.left = left.toFloat()
        frame.top = top.toFloat()
        frame.right = right.toFloat()
        frame.bottom = bottom.toFloat()
    }

    fun draw(canvas: Canvas?) {
        if (canvas == null) {
            return
        }
        if (this.isHidden) {
            return
        }

        if (this.text.isNullOrEmpty()) {
            lastText = text
            return
        }
        if (lastText != text) {
            text = calculateEms(ems, text)
        }
        lastText = text

//        if (text.contains('\n')) {
//            var l = frame.left + 8.dp
//            var t = frame.top + 12.dp
//            canvas.save()
//            val texts = text.split("\n".toRegex()).toTypedArray()
//            for (i in texts.indices) {
//                canvas.translate(l, t)
//                if (i > texts.size - 1) {
//                    t += paint.descent() - paint.ascent()
//                } else {
//                    t += 10.dp
//                }
//            }
//            canvas.restore()
//            background?.setBounds(
//                frame.left.toInt(), frame.top.toInt(),
//                frame.right.toInt(), frame.bottom.toInt()
//            )
//            background?.draw(canvas)
//        } else {
//            background?.setBounds(
//                frame.left.toInt(), frame.top.toInt(),
//                frame.right.toInt(), frame.bottom.toInt()
//            )
//            background?.draw(canvas)
//        }
        background?.setBounds(
            frame.left.toInt(), frame.top.toInt(),
            frame.right.toInt(), frame.bottom.toInt()
        )
        background?.draw(canvas)
        drawText(canvas)
    }

    private fun drawText(canvas: Canvas) {
        if (text.contains('\n')) {
            val dx = (frame.left + frame.width() / 2)
            var centerVerticalY = (frame.top + frame.height() / 2) + paddingTop/* + height / 4*/
            var y = frame.top + paddingTop + 14.dp/* frame.height()/2 *//*/ 2*/
            val x = (frame.left + paddingLeft)
            var centerY = (frame.top /*+ frame.height() / 2 - frame.height()/4*/ + height / 2) /*+ paddingTop*/ /*+ height / 4*/
            for (line in text.split("\n".toRegex()).toTypedArray()) {

                if (gravity == Gravity.CENTER_HORIZONTAL) {
                    canvas.drawText(line, dx - getTextWidth(paint, line) / 2, y, paint)
                    y += paint.descent() - paint.ascent()
                } else if (gravity == Gravity.CENTER) {
                    canvas.drawText(line, dx - getTextWidth(paint, line) / 2, centerY, paint)
                    centerY += paint.descent() - paint.ascent()

                } else if (gravity == Gravity.CENTER_VERTICAL) {
                    canvas.drawText(line, x, centerVerticalY, paint)
                    centerVerticalY += paint.descent() - paint.ascent()
                } else {
                    canvas.drawText(line, x, y, paint)
                    y += paint.descent() - paint.ascent()
                }

            }
        } else {
//            canvas.drawText(text, (frame.left + 8.dp) + paddingLeft, (frame.top + 12.dp) + paddingTop, paint)

            val dx = (frame.left + frame.width() / 2)
            val y = frame.top + paddingTop + frame.height()/2 /*/ 2*/
            val x = (frame.left + paddingLeft)
            val centerVerticalY = (frame.top + frame.height() / 2) + paddingTop /*+ height / 4*/
            var centerY = (frame.top /*+ frame.height() / 2 - frame.height()/4*/ + height / 2) /*+ paddingTop*/ /*+ height / 4*/
            if (gravity == Gravity.CENTER_HORIZONTAL) {
                canvas.drawText(text, dx - getTextWidth(paint, text) / 2, y, paint)
            } else if (gravity == Gravity.CENTER) {
                canvas.drawText(text, dx - getTextWidth(paint, text) / 2, centerY, paint)
            } else if (gravity == Gravity.CENTER_VERTICAL) {
                canvas.drawText(text, x, centerVerticalY, paint)

            } else {
                canvas.drawText(text, (frame.left /*+ 8.dp*/) + paddingLeft, (frame.top/* + 12.dp*/) /*+ paddingTop*/ + height, paint)
//                canvas.drawText(text, x, y, paint)
            }

//            if (gravity == Gravity.CENTER_HORIZONTAL) {
//                canvas.drawText(text, (frame.left) - (frame.width() + getTextWidth(paint, text)) / 2 + paddingLeft, (frame.top + 12.dp) + paddingTop, paint)
//            } else {
//                canvas.drawText(text, (frame.left + 8.dp) + paddingLeft, (frame.top + 12.dp) + paddingTop, paint)
//            }
        }
    }

    fun getTextWidth(paint: TextPaint, str: String?): Int { //calculate text width
        var iRet = 0
        if (str != null && str.isNotEmpty()) {
            val len = str.length
            val widths = FloatArray(len)
            paint.getTextWidths(str, widths)
            for (j in 0 until len) {
                iRet += ceil(widths[j].toDouble()).toInt()
            }
        }
        return iRet
    }

    private fun getMaxTextWidth(paint: TextPaint, str: String?): Double { //calculate text width
        var textWidth = 0.0
        val bounds = Rect()
        for (line in text.split("\n")) {
            paint.getTextBounds(line, 0, line.length, bounds)
            if (textWidth < bounds.width()) {
                textWidth = bounds.width().toDouble()
            }
        }

        return textWidth
    }
}