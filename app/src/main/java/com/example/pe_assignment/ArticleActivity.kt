package com.example.pe_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        constructGategoryView(this@ArticleActivity)
        constructHotView(this@ArticleActivity)
        constructRecentView(this@ArticleActivity)
        constructHandpickView(this@ArticleActivity)
    }
}

fun constructGategoryView(context: AppCompatActivity) {
    val categoryAdapter = CategoryAdapter(categoryList())

    val categoryRecyclerView = context.findViewById<RecyclerView>(R.id.category_recyclerview)

    val linearLayoutManager = LinearLayoutManager(
        context,
        LinearLayoutManager.HORIZONTAL,
        false
    )

    categoryRecyclerView.layoutManager = linearLayoutManager
    categoryRecyclerView.adapter = categoryAdapter

}

fun constructHotView(context: AppCompatActivity) {

    val hotAdapter = HotAdapter(hotList())

    val hotRecyclerView = context.findViewById<RecyclerView>(R.id.hot_recyclerview)

    val linearLayoutManager = LinearLayoutManager(
        context,
        LinearLayoutManager.HORIZONTAL,
        false
    )

    hotRecyclerView.layoutManager = linearLayoutManager
    hotRecyclerView.adapter = hotAdapter
}

fun constructRecentView(context: AppCompatActivity) {

    val recentAdapter = HotAdapter(recentList())

    val recentRecyclerView = context.findViewById<RecyclerView>(R.id.recent_recyclerview)

    val linearLayoutManager = LinearLayoutManager(
        context,
        LinearLayoutManager.HORIZONTAL,
        false
    )

    recentRecyclerView.layoutManager = linearLayoutManager
    recentRecyclerView.adapter = recentAdapter
}

fun constructHandpickView(context: AppCompatActivity) {

    val handpickAdapter = HotAdapter(handpickList())

    val handpickRecyclerView = context.findViewById<RecyclerView>(R.id.handpick_recyclerview)

    val linearLayoutManager = LinearLayoutManager(
        context,
        LinearLayoutManager.HORIZONTAL,
        false
    )

    handpickRecyclerView.layoutManager = linearLayoutManager
    handpickRecyclerView.adapter = handpickAdapter
}


fun categoryList(): ArrayList<CategoryModel> {
    val categoryList = ArrayList<CategoryModel>()
    categoryList.add(
        CategoryModel(1, "Sex")
    )
    categoryList.add(
        CategoryModel(2, "Health")
    )
    categoryList.add(
        CategoryModel(3, "Disease")
    )
    categoryList.add(
        CategoryModel(4, "Sport")
    )

    return categoryList
}

fun hotList(): ArrayList<HotModel> {
    val hotList = ArrayList<HotModel>()
    hotList.add(
        HotModel(1, R.drawable.articlelist_1)
    )
    hotList.add(
        HotModel(2, R.drawable.articlelist_2)
    )
    hotList.add(
        HotModel(3, R.drawable.articlelist_3)
    )

    return hotList
}

fun recentList(): ArrayList<HotModel> {
    val recentList = ArrayList<HotModel>()
    recentList.add(
        HotModel(1, R.drawable.articlelist_4)
    )
    recentList.add(
        HotModel(2, R.drawable.articlelist_5)
    )
    recentList.add(
        HotModel(3, R.drawable.articlelist_6)
    )

    return recentList
}

fun handpickList(): ArrayList<HotModel> {
    val handpickList = ArrayList<HotModel>()
    handpickList.add(
        HotModel(1, R.drawable.articlelist_7)
    )
    handpickList.add(
        HotModel(2, R.drawable.articlelist_8)
    )
    handpickList.add(
        HotModel(3, R.drawable.articlelist_9)
    )

    return handpickList
}