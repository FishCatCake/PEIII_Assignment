package com.example.pe_assignment

import android.app.Application
import com.example.pe_assignment.database.UserDatabase
import com.example.pe_assignment.database.repository.*
import com.example.pe_assignment.database.repository.HpvRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BaseApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database: UserDatabase by lazy { UserDatabase.getInstance(this, applicationScope) }
    val repository: RegisterRepository by lazy { RegisterRepository(database.userDao()) }
    // cycle
    // val repositoryCycle: CycleRepository by lazy { CycleRepository(database.cycleDao()) }
    val repoPeriod: PeriodRepository by lazy {PeriodRepository(database.cycleDao())}
    val repository_cancernew: CancerNewRepository by lazy { CancerNewRepository(database.usercancerphraseDao()) }
    val repository_cancerrecord: CancerRecordRepository by lazy { CancerRecordRepository(database.usercancerrecordDao()) }
    val repository_cancertimeline: TimelineRecordRepository by lazy { TimelineRecordRepository(database.usercancertimelineDao()) }

    val hpvrepository: HpvRepository by lazy { HpvRepository(database.hpvDao()) }

}