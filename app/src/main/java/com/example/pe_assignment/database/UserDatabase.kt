package com.example.pe_assignment.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pe_assignment.database.dao.*
import com.example.pe_assignment.database.entity.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class, Cycle::class, UserCancerPhrase::class,CancerRecord::class,TimelineRecord::class, HPV::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun cycleDao(): CycleDao
    abstract fun hpvDao():HPVDao

    abstract fun usercancerphraseDao(): UserCancerPhraseDao
    abstract fun usercancerrecordDao(): CancerRecordDao
    abstract fun usercancertimelineDao(): TimelineRecordDao

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var userDao = database.userDao()
                    var cycleDao = database.cycleDao()

                    var usercancerphraseDao = database.usercancerphraseDao()
                    var usercancerrecordDao = database.usercancerrecordDao()
                    var usercancertimelineDao = database.usercancertimelineDao()

                    // Delete all content here.
                    userDao.deleteAll()
                    usercancerphraseDao.deleteAll()
                    usercancerrecordDao.deleteAll()
                    usercancertimelineDao.deleteAll()

//                    // Add sample words.
                    var user = User(0,"Sample","Sample","Sample","Sample")
                    userDao.insert(user)

                    // sample temp
                    var cycle = Cycle(0, 2022f,12f,30f,37f, "Had Flow", "Heavy", "Acne")
                    cycleDao.insert(cycle)

                    var cuser = UserCancerPhrase(0,"Sample","1")
                    usercancerphraseDao.insert(cuser)
                    var crecord = CancerRecord(0,"Sample","Sample","Sample","Sample","Sample","Sample","1")
                    usercancerrecordDao.insert(crecord)

                    var ctimeline = TimelineRecord(0,"Sample","Sample","Sample","Sample","Sample","Sample","1")
                    usercancertimelineDao.insert(ctimeline)

                }
            }
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getInstance(
            context: Context,
            scope: CoroutineScope
        ): UserDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "x_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(UserDatabaseCallback(scope))
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
