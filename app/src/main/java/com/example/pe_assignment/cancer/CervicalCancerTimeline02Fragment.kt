package com.example.pe_assignment.cancer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.pe_assignment.BaseApplication
import com.example.pe_assignment.R
import com.example.pe_assignment.databinding.FragmentCancerTimelineCalendarBinding
import com.example.pe_assignment.databinding.FragmentCervicalCancerTimeline02Binding


class CervicalCancerTimeline02fragment : Fragment() {
    private var binding: FragmentCervicalCancerTimeline02Binding? = null
    private val sharedViewModel: CancerTimelineViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentCervicalCancerTimeline02Binding.inflate(
            inflater, container, false
        )
        val sharedViewModel: CancerTimelineViewModel by activityViewModels() {
            CancerTimelineViewModelFactory((activity?.application as BaseApplication).repository_cancertimeline)
        }
        sharedViewModel.navigateto.observe(viewLifecycleOwner, Observer {
                hasFinished ->  // if it is true
            if(hasFinished == true) {
//                    goToNextScreen()
                sharedViewModel.doneNavigating()
            }
        })

        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            myViewModel = sharedViewModel
            desFragment = this@CervicalCancerTimeline02fragment
        }

        val btnback = view.findViewById<ImageButton>(R.id.back)
        btnback.setOnClickListener {
            view.findNavController().navigate(R.id.timelineUploadFragment)
        }
    }

    fun goToNextScreen() {
        val title: String = binding?.timelineTitle?.text.toString()
        val des: String = binding?.timelineDes?.text.toString()
        sharedViewModel.setTitle(title)
        sharedViewModel.setDescription(des)
        sharedViewModel.addTimeline()
        findNavController().navigate(R.id.action_cervicalCancerTimeline02fragment3_to_timelineinfoboardFragment)
    }
}