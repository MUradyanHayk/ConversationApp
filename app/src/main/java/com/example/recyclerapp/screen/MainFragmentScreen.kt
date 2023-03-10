package com.example.recyclerapp.screen

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerapp.adapter.MainAdapter
import com.example.recyclerapp.model.MainModel
import com.example.recyclerapp.model.MainModelType
import com.example.recyclerapp.utils.dp
import com.example.recyclerapp.utils.setPaddings

class MainFragmentScreen @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {
    private var recyclerView: RecyclerView? = null
    private var adapter: MainAdapter? = null

    init {
        this.layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        createRecyclerView()
    }

    private fun createRecyclerView() {
        recyclerView = RecyclerView(context)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        recyclerView?.layoutParams = params
        recyclerView?.clipToPadding = false
        recyclerView?.setPaddings(16.dp)
        adapter = MainAdapter(context, createDataSource())
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        addView(recyclerView)
    }

    private fun createDataSource(): MutableList<MainModel> {
        val list = mutableListOf<MainModel>()

        var model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)


        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)


        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)


        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = true
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)
        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)


        model = MainModel()
        model.type = MainModelType.ITEM
        model.isInComing = false
        model.name = "askdas;ld asdsdv sdsd sd f fwsd"
        list.add(model)

        return list
    }
}