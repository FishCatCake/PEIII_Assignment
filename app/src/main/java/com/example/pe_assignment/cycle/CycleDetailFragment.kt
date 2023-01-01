package com.example.pe_assignment.cycle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.coroutineScope
import androidx.navigation.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.database.entity.Cycle
import com.example.pe_assignment.databinding.FragmentCycleDetailBinding
import kotlinx.android.synthetic.main.article_share_header.*
import kotlinx.android.synthetic.main.fragment_cycle_detail.view.*
import kotlinx.coroutines.launch
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class CycleDetailFragment : Fragment() {
    private var binding: FragmentCycleDetailBinding? = null
    private val sharedViewModel: PeriodViewModel by activityViewModels()

    // array list
    lateinit var arrayList: ArrayList<Entry>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentCycleDetailBinding.inflate(
            inflater, container, false
        )
        val sharedViewModel: PeriodViewModel by activityViewModels() {
            PeriodViewModelFactory((activity?.application as BaseApplication).repoPeriod)

        }


//        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
//                hasFinished ->  // if it is true
//            if(hasFinished == true) {
//                // gotoNext...
//                sharedViewModel.doneNavigating()
//            }
//        })

        binding = fragmentBinding
        return fragmentBinding.root
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            periodViewModel = sharedViewModel
            cycleDetailFragment = this@CycleDetailFragment
        }

        var btnBack = view.findViewById<ImageButton>(R.id.btn_back_detail)
        btnBack.setOnClickListener{
            view.findNavController().navigate(R.id.cycleFragment)
        }
        // temp chart
        var tempChart = view.findViewById<com.github.mikephil.charting.charts.LineChart>(R.id.temp_chart)
        lifecycle.coroutineScope.launch{
//            var cycle_date_list = arrayOf(sharedViewModel.dateList)
//            var cycle_temp_list = arrayOf(sharedViewModel.tempList)
//            Log.i("list", cycle_date.toString())
//            Log.i("list", cycle_temp.toString())

            sharedViewModel.getAll().collect{
                arrayList = ArrayList<com.github.mikephil.charting.data.Entry>()
                val arrayListx = ArrayList<String>()

                for (items in it.indices){
                    arrayList.add(com.github.mikephil.charting.data.Entry(items.toFloat(), it[items].temperature))
                    arrayListx.add(it[items].date.toString())
                    val  lineDataset = LineDataSet(arrayList,"Temperature")
                    val data = LineData(lineDataset)
                    tempChart.data = data
                    tempChart.animateXY(3000, 3000)
                    lineDataset.setCircleColor(60)
                    lineDataset.setCircleRadius(5f)
                    lineDataset.setColor(255,50)
                    lineDataset.setDrawHighlightIndicators(true)
                    lineDataset.setLineWidth(5f)
                    lineDataset.setValueTextSize(10f)


                    val xaxis: XAxis = tempChart.xAxis
//                    xaxis.valueFormatter = IndexAxisValueFormatter{value, axis ->arrayListx[value.toInt()]}
                    xaxis.setDrawGridLines(false)
//                    xaxis.position(XAxis.XAxisPosition.BOTTOM)
                }

            }


        }
    }

}

