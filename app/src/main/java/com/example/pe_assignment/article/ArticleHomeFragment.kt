package com.example.pe_assignment.article

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.*


class ArticleHomeFragment : Fragment() {
    //Category
    private lateinit var catadapter: CategoryAdapter
    private lateinit var catrecyclerView: RecyclerView
    private lateinit var catArrayList: ArrayList<CategoryModel>
    private lateinit var category : Array<String>
    //Hot articles
    private lateinit var hotadapter: HotAdapter
    private lateinit var hotrecyclerView: RecyclerView
    private lateinit var hotArrayList: ArrayList<HotModel>
    private lateinit var hotarticle : Array<Int>
    //Recent articles
    private lateinit var recentadapter: HotAdapter
    private lateinit var recentrecyclerView: RecyclerView
    private lateinit var recentArrayList: ArrayList<HotModel>
    private lateinit var recentarticle : Array<Int>
    //Handpick articles
    private lateinit var handadapter: HotAdapter
    private lateinit var handrecyclerView: RecyclerView
    private lateinit var handArrayList: ArrayList<HotModel>
    private lateinit var handarticle : Array<Int>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        category()
        hotarticle()
        recentarticle()
        handarticle()
        //Category
        val catlayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        catrecyclerView = view.findViewById(R.id.category_recyclerview)
        catrecyclerView.layoutManager = catlayoutManager
        catrecyclerView.setHasFixedSize(true)
        catadapter = CategoryAdapter(catArrayList)
        catrecyclerView.adapter = catadapter

        //Hot article
        val hotlayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        hotrecyclerView = view.findViewById(R.id.hot_recyclerview)
        hotrecyclerView.layoutManager = hotlayoutManager
        hotrecyclerView.setHasFixedSize(true)
        hotadapter = HotAdapter(hotArrayList)
        hotrecyclerView.adapter = hotadapter
        //Recent article
        val recentlayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recentrecyclerView = view.findViewById(R.id.recent_recyclerview)
        recentrecyclerView.layoutManager = recentlayoutManager
        recentrecyclerView.setHasFixedSize(true)
        recentadapter = HotAdapter(recentArrayList)
        recentrecyclerView.adapter = recentadapter
        //Handpick article
        val handlayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        handrecyclerView = view.findViewById(R.id.handpick_recyclerview)
        handrecyclerView.layoutManager = handlayoutManager
        handrecyclerView.setHasFixedSize(true)
        handadapter = HotAdapter(handArrayList)
        handrecyclerView.adapter = handadapter



        var btnSend = view.findViewById<ImageButton>(R.id.read_btn1)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.articleFragment)
        }
        btnSend = view.findViewById(R.id.read_btn2)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.articleFragment)
        }
        btnSend = view.findViewById(R.id.read_btn3)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.articleFragment)
        }

        btnSend = view.findViewById(R.id.back_btn)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.homeActivity)
        }

    }

    private fun category(){
        catArrayList = arrayListOf()
        category = arrayOf(
            "Sex",
            "Health",
            "Disease",
            "Sport"
        )

        for(i in category.indices){
            val category = CategoryModel(category[i])
            catArrayList.add(category)
        }
    }

    private fun hotarticle(){
        hotArrayList = arrayListOf()
        hotarticle = arrayOf(
            R.drawable.articlelist_1,
            R.drawable.articlelist_2,
            R.drawable.articlelist_3
        )

        for(i in hotarticle.indices){
            val hotarticle = HotModel(hotarticle[i])
            hotArrayList.add(hotarticle)
        }
    }

    private fun recentarticle(){
        recentArrayList = arrayListOf()
        recentarticle = arrayOf(
            R.drawable.articlelist_4,
            R.drawable.articlelist_5,
            R.drawable.articlelist_6
        )

        for(i in recentarticle.indices){
            val recentarticle = HotModel(recentarticle[i])
            recentArrayList.add(recentarticle)
        }
    }

    private fun handarticle(){
        handArrayList = arrayListOf()
        handarticle = arrayOf(
            R.drawable.articlelist_7,
            R.drawable.articlelist_8,
            R.drawable.articlelist_9
        )

        for(i in handarticle.indices){
            val handarticle = HotModel(handarticle[i])
            handArrayList.add(handarticle)
        }


    }
}
