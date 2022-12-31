package com.example.pe_assignment.cycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.pe_assignment.R
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI

class MenstruationActivity : AppCompatActivity() {
    //private lateinit var navController: NavController

//    private val periodViewModel: PeriodViewModel by lazy{
//        this?.run{
//            ViewModelProvider(this, PeriodViewModelFactory((this?.application as CycleApplication)
//                .dataBase.CycleDAO())).get(CycleViewModel::class.java)
//        }?:throw Exception("Invalid")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menstruation)

       // navController = Navigation.findNavController(this, R.id.cycle_container)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, null)
//    }
}