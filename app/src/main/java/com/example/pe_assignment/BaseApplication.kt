package com.example.pe_assignment

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BaseApplication : Application() {
    val database: UserDatabase by lazy { UserDatabase.getInstance(this) }
    val repository: RegisterRepository by lazy { RegisterRepository(database.userDao()) }
}