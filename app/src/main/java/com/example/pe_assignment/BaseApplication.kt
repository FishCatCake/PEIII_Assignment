package com.example.pe_assignment

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BaseApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database: UserDatabase by lazy { UserDatabase.getInstance(this, applicationScope) }
    val repository: RegisterRepository by lazy { RegisterRepository(database.userDao()) }
    val repository_cancernew: CancerNewRepository by lazy { CancerNewRepository(database.usercancerphraseDao()) }
    val repository_cancerrecord: CancerRecordRepository by lazy { CancerRecordRepository(database.usercancerrecordDao())}
}