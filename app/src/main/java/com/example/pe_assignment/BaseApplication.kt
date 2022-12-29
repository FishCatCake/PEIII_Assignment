package com.example.pe_assignment

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pe_assignment.hpv.HpvRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BaseApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database: UserDatabase by lazy { UserDatabase.getInstance(this, applicationScope) }
    val repository: RegisterRepository by lazy { RegisterRepository(database.userDao()) }
    val hpvrepository: HpvRepository by lazy { HpvRepository(database.hpvDao()) }

}