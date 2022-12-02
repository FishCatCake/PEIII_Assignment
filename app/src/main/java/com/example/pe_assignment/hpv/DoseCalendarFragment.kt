package com.example.pe_assignment.hpv

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pe_assignment.R


class DoseCalendarFragment : Fragment() {

    private lateinit var adapter: HpvCalendarAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var calendarArrayList: ArrayList<HpvCalendarModel>
    lateinit var page : Array<String>
    lateinit var dose : Array<String>
//    lateinit var calendar : Array<Int>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dose_calendar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView = view.findViewById(R.id.recycler_record)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = HpvCalendarAdapter(calendarArrayList)
        recyclerView.adapter = adapter

        val btnSend = view.findViewById<Button>(R.id.next_btn1)
        btnSend.setOnClickListener {
            view.findNavController().navigate(R.id.hpvReminderFragment)
        }
        var btnSend2 = view.findViewById<ImageButton>(R.id.skip)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.hpvReminderFragment)
        }
        btnSend2 = view.findViewById<ImageButton>(R.id.back)
        btnSend2.setOnClickListener {
            view.findNavController().navigate(R.id.reviewCalendarFragment)
        }

    }

    private fun dataInitialize(){
        calendarArrayList = arrayListOf<HpvCalendarModel>()
        page = arrayOf(
            "1/3",
            "2/3",
            "3/3"
        )

        dose = arrayOf(
            "Date of First " +
                    "Dose Onset",
            "Date of Second " +
                    "Dose Onset",
            "Date of Third " +
                    "Dose Onset"
        )

//        calendar = arrayOf(
//            1,
//            2,
//            3
//        )
        for(i in page.indices){
            val calendar = HpvCalendarModel(page[i],dose[i])
            calendarArrayList.add(calendar)
        }
    }
}