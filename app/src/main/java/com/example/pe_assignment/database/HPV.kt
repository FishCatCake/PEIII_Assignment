package com.example.pe_assignment.database

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.pe_assignment.User
import java.util.Date

@Entity(tableName = "hpv_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id"),
    )]
)

data class HPV(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "Review_time_year")
    val ReviewTimeYear: Int,

    @ColumnInfo(name = "Review_time_month")
    val ReviewTimeMonth: Int,

    @ColumnInfo(name = "Review_time_day")
    val ReviewTimeDay: Int

//    @ColumnInfo(name = "First_vaccine_time")
//    @TypeConverters(Converters::class)
//    val firstVaccineTime: MutableLiveData<Date?>,
//
//    @ColumnInfo(name = "Second_vaccine_time")
//    @TypeConverters(Converters::class)
//    val secondVaccineTime: MutableLiveData<Date?>,
//
//    @ColumnInfo(name = "Third_vaccine_time")
//    @TypeConverters(Converters::class)
//    val thirdVaccineTime: MutableLiveData<Date?>,
)
class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time?.toLong()
    }
}