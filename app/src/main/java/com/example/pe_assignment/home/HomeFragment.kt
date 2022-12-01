package com.example.pe_assignment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.pe_assignment.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cdCycle = view.findViewById<CardView>(R.id.cd_cycle)
        val cdVaccine = view.findViewById<CardView>(R.id.cd_vaccine)
        val cdCancer = view.findViewById<CardView>(R.id.cd_cancer)
        val cdArticle = view.findViewById<CardView>(R.id.cd_forum)
        cdCycle.setOnClickListener{
            view.findNavController().navigate(R.id.menstruationActivity)
        }

        cdVaccine.setOnClickListener {
            view.findNavController().navigate(R.id.HPVActivity)
        }

        cdCancer.setOnClickListener {
            view.findNavController().navigate(R.id.cancerNewUserActivity)
        }

        cdArticle.setOnClickListener {
            view.findNavController().navigate(R.id.articleActivity)
        }
   }

}