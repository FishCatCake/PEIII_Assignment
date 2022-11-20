package com.example.pe_assignment

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.Toast

class CancerCalendar : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancer_calendar)

        val calendarView: CalendarView = findViewById(R.id.calendarView3)
        calendarView.setOnDateChangeListener{view,year,month,dateOfMonth ->
            val msg = "Selected Date: " + dateOfMonth + "/ " + (month+1) + "/ " +year

            Toast.makeText(this,msg, Toast.LENGTH_LONG).show()

        }
    }

}