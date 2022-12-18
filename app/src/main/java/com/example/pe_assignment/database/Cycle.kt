package com.example.pe_assignment.database

import androidx.room.*
import java.util.*

@Entity(tableName = "cycle_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("user_id"),
    )]
)
data class Cycle(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "start_time")
    @TypeConverters(Converters::class)
    val startTime: Date?,

    @ColumnInfo(name = "symptom")
    val symptomId: String,

    @ColumnInfo(name = "temperature")
    val temperatureId: String,

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