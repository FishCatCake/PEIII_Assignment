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
import com.example.pe_assignment.hpv.ImageAdapter
import com.example.pe_assignment.hpv.ImageModel
import com.example.pe_assignment.R


class ArticleFragment : Fragment() {

    private lateinit var adapter: ImageAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var imageArrayList: ArrayList<ImageModel>
    private lateinit var image : Array<Int>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView = view.findViewById(R.id.recycler_image)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = ImageAdapter(imageArrayList)
        recyclerView.adapter = adapter

        val btnSend = view.findViewById<ImageButton>(R.id.back)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.articleHomeFragment)
        }
    }

    private fun dataInitialize(){
        imageArrayList = arrayListOf()
        image = arrayOf(
            R.drawable.article_1,
            R.drawable.article_1,
            R.drawable.article_1
        )


        for(i in image.indices){
            val image = ImageModel(image[i])
            imageArrayList.add(image)
        }
    }
}