package com.example.pe_assignment.database

import android.app.Application
import com.example.pe_assignment.RegisterRepository
import com.example.pe_assignment.UserDatabase

class HPVApplication : Application() {

    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val repository: HpvRepository by lazy { HpvRepository(database.hpvDao()) }
}