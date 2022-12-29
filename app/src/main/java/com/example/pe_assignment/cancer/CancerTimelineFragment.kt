package com.example.pe_assignment.cancer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R


class CancerTimelineFragment : Fragment() {

    private lateinit var adapter: TimelineAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var timeArrayList: ArrayList<Timeline>
    lateinit var title : Array<String>
    lateinit var date : Array<String>
    lateinit var info : Array<String>
    //lateinit var btn : Array<String>
    private val sharedViewModel: CancerTimelineViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val sharedViewModel: CancerRecordViewModel by activityViewModels() {
//            CancerTimelineViewModelFactory((activity?.application as BaseApplication).repository_cancertimeline)
//        }
//        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
//                hasFinished ->  // if it is true
//            if(hasFinished == true) {
////                    goToNextScreen()
//                sharedViewModel.doneNavigating()
//            }
//        })
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
            view.findNavController().navigate(R.id.cancer_graph)
        }
        val btn_mycycle = view.findViewById<Button>(R.id.btn_mycycle)
        btn_mycycle.setOnClickListener {
            view.findNavController().navigate(R.id.menstruationActivity3)
        }

        val btn_newrecord = view.findViewById<Button>(R.id.btn_cancer_record_new)
        btn_newrecord.setOnClickListener {
            view.findNavController().navigate(R.id.cancerTimelineCalendar)
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