package com.example.pe_assignment.hpv

import androidx.room.*
import com.example.pe_assignment.User
import java.util.Date

@Entity(tableName = "hpv_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id")
    )]
)

data class HPV(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

//    @ColumnInfo(name = "Review_time_year")
//    val ReviewTimeYear: Int,
//
//    @ColumnInfo(name = "Review_time_month")
//    val ReviewTimeMonth: Int,
//
//    @ColumnInfo(name = "Review_time_day")
//    val ReviewTimeDay: Int

    @ColumnInfo(name = "Review_time_year")
    @TypeConverters(Converters::class)
    val reviewTime: Date,

    @ColumnInfo(name = "First_vaccine_time")
    @TypeConverters(Converters::class)
    val firstVaccineTime: Date,

    @ColumnInfo(name = "Second_vaccine_time")
    @TypeConverters(Converters::class)
    val secondVaccineTime: Date,

    @ColumnInfo(name = "Third_vaccine_time")
    @TypeConverters(Converters::class)
    val thirdVaccineTime: Date,
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