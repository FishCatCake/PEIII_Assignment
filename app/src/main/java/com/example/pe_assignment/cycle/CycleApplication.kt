package com.example.pe_assignment.cycle

import android.app.Application
import com.example.pe_assignment.database.AppDatabase

class CycleApplication : Application() {

    val dataBase: AppDatabase by lazy { AppDatabase.getDatabase(this)}
}