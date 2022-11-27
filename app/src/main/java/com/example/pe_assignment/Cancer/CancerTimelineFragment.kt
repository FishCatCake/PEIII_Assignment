package com.example.pe_assignment.Cancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R


class CancerTimelineFragment : Fragment() {

    private lateinit var adapter: TimelineAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var timeArrayList: ArrayList<Timeline>
    lateinit var title : Array<String>
    lateinit var date : Array<String>
    lateinit var info : Array<String>
    //lateinit var btn : Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cancer_timeline, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_timeline)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = TimelineAdapter(timeArrayList)
        recyclerView.adapter = adapter

        val btn_cal = view.findViewById<Button>(R.id.btn_cal)
        btn_cal.setOnClickListener {
            view.findNavController().navigate(R.id.cancerCalendarFragment)
        }

    }

    private fun dataInitialize(){
        timeArrayList = arrayListOf<Timeline>()
        title = arrayOf(
            getString(R.string.title_1),
            getString(R.string.title_2),
            getString(R.string.title_3)
        )

        date = arrayOf(
            getString(R.string.data_1),
            getString(R.string.data_2),
            getString(R.string.data_3)

        )
        info = arrayOf(
            getString(R.string.info_1),
            getString(R.string.info_2),
            getString(R.string.info_3)
        )

        for(i in title.indices){
            val time = Timeline(title[i],info[i],date[i])
            timeArrayList.add(time)
        }
    }
}