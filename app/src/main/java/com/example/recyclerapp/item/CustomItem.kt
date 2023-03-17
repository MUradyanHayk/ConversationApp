package com.example.recyclerapp.item

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.example.recyclerapp.utils.ScreenResolutionManager
import com.example.recyclerapp.utils.dp

class CustomItem @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : View(context, attrs) {
    private var paint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var rect: Rect = Rect()
    private var rectF: RectF =  RectF()


    init {

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val w = MeasureSpec.getSize(ScreenResolutionManager.getScreenWidth(context))
        val h = MeasureSpec.getSize(300.dp)
        setMeasuredDimension(w, h)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
//        canvas?.drawColor(Color.GREEN)

        canvas?.drawARGB(80, 102, 204, 255)

        paint.color = Color.RED
        paint.strokeWidth = 10f

        canvas?.drawPoint(50f, 50f, paint)
        canvas?.drawLine(100f, 100f, 500f, 50f, paint)
        canvas?.drawCircle(100f, 200f, 50f, paint)
        canvas?.drawRect(200f, 150f, 400f, 200f, paint)
        rect.set(250, 300, 350, 500)
        rectF.set(250f, 300f, 350f, 500f)

//        canvas?.drawRect(rect, paint)
        canvas?.drawRoundRect(rectF, 16f, 16f, paint)


        paint.color = Color.GREEN
        paint.strokeWidth = 5f

        val x1 = measuredWidth - 100f.dp
        val y1 = measuredHeight * 0.5f + 100.dp

        val x2 = x1
        val y2 = y1 - 300f


        canvas?.drawLine(x1, y1, x2, y2, paint)



        paint.color = Color.BLUE

        paint.textSize = 28f

        canvas?.drawText("Draw Text !!!", x1, y1, paint)

        paint.textAlign = Paint.Align.CENTER
        canvas?.drawText("Draw Text !!!", x1, y1 - 30f, paint)

        paint.textAlign = Paint.Align.RIGHT
        canvas?.drawText("Draw Text !!!", x1, y1 - 60f, paint)

        paint.textAlign = Paint.Align.LEFT
        canvas?.drawText("Draw Text !!!", x1, y1 - 90f, paint)

    }
}