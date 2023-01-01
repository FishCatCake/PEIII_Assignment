package com.example.pe_assignment.home



import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs

import com.example.pe_assignment.R

class HomeActivity : AppCompatActivity() {
    val args: HomeActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val name = args.name
        Log.i("recieve1",name)

//        val bundle = Bundle()
//        bundle.putString("name","test")
//        val fragment = HomeFragment()
//        fragment.arguments = bundle

    }

}