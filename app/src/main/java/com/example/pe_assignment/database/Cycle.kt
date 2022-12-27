package com.example.pe_assignment.database
//
//import androidx.room.*
//import java.util.Date
//
//@Entity(tableName = "cycle_table",
//    foreignKeys = [ForeignKey(
//        entity = User::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("user_id"),
//    )]
//)
//data class Cycle(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
//
//    @ColumnInfo(name = "year")
//    val year: Int,
//
//    @ColumnInfo(name = "month")
//    val month: Int,
//
//    @ColumnInfo(name = "date")
//    val date: Int,
//
//    @ColumnInfo(name = "temperature")
//    val temperature: Double,
//
////    @ColumnInfo(name = "symptoms_1")
////    val symptoms1: String?,
////    @ColumnInfo(name = "symptoms_2")
////    val symptoms2: String?,
////    @ColumnInfo(name = "symptoms_3")
////    val symptoms3: String?,
////    @ColumnInfo(name = "symptoms_4")
////    val symptoms4: String?,
////    @ColumnInfo(name = "symptoms_5")
////    val symptoms5: String?,
//
//)
//
////public class Converters {
////    @TypeConverter
////    fun fromTimestamp(value: Long?): Date? {
////        return value?.let { Date(it) }
////    }
////
////    @TypeConverter
////    fun dateToTimestamp(date: Date?): Long? {
////        return date?.time?.toLong()
////    }
////}