package com.example.pe_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CardRecyclerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_recycler)

        constructRecyclerView(this@CardRecyclerActivity)
    }
}

fun constructRecyclerView(context: AppCompatActivity) {
    val listAdapter = ListAdapter(attrList())

    val listRecyclerView = context.findViewById<RecyclerView>(R.id.list_recyclerview)

    val linearLayoutManager = LinearLayoutManager(
        context,
        LinearLayoutManager.VERTICAL,
        false
    )

//    val gridLayoutManager = GridLayoutManager(
//        context,
//        2,
//        RecyclerView.VERTICAL,
//        false
//    )
    listRecyclerView.layoutManager = linearLayoutManager
    listRecyclerView.adapter = listAdapter
}

fun attrList(): ArrayList<ListModel> {
    val attrList = ArrayList<ListModel>()
    attrList.add(
        ListModel(1, "Phase 1")
    )
    attrList.add(
        ListModel(2, "Phase 2")
    )
    attrList.add(
        ListModel(3, "Phase 3")
    )
    attrList.add(
        ListModel(4, "Phase 4")
    )

    return attrList
}