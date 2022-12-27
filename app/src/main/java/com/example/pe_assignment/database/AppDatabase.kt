package com.example.pe_assignment.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//
////@TypeConverters(Converters::class)
//@Database(entities = [User::class, Cycle::class, HPV::class, Cancer::class, Treatment::class], version = 1)
//abstract class AppDatabase:RoomDatabase() {
//    abstract fun CycleDAO():CycleDAO
//
//    companion object{
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context):AppDatabase{
//            return INSTANCE?: synchronized(this){
//                val instance = Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase").allowMainThreadQueries().build()
//
//                INSTANCE = instance
//
//                instance
//            }
//
//        }
//    }
//}