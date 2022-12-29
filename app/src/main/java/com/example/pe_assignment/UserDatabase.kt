package com.example.pe_assignment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.pe_assignment.hpv.HPV
import com.example.pe_assignment.hpv.HPVDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [User::class,HPV::class], version = 3, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun hpvDao(): HPVDao

    private class UserDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    val userDao = database.userDao()
                    val hpvDao = database.hpvDao()
                    // Delete all content here.
                    userDao.deleteAll()
                    hpvDao.deleteAll()
//                    // Add sample words.
                    val user = User(0,"Sample","Sample","Sample","Sample")
                    userDao.insert(user)

                    val hpv = HPV(0,0)
                    hpvDao.insert(hpv)
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
                    "u_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(UserDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}
