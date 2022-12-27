package com.example.pe_assignment

import android.app.Application
import com.example.pe_assignment.database.UserDatabase
import com.example.pe_assignment.database.repository.CycleRepository
import com.example.pe_assignment.database.repository.RegisterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BaseApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database: UserDatabase by lazy { UserDatabase.getInstance(this, applicationScope) }
    val repository: RegisterRepository by lazy { RegisterRepository(database.userDao()) }
    // cycle
    val repositoryCycle: CycleRepository by lazy { CycleRepository(database.cycleDao()) }
}