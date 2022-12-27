package com.example.pe_assignment.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "cycle_table",
//    foreignKeys = [ForeignKey(
//        entity = User::class,
//        parentColumns = arrayOf("id"),
//        childColumns = arrayOf("user_id"),
//    )]
)
data class Cycle(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "cycle_year")
    val year: Int,

    @ColumnInfo(name = "cycle_month")
    val month: Int,

    @ColumnInfo(name = "cycle_date")
    val date: Int,

    @ColumnInfo(name = "temperature")
    val temperature: Double,

//    @ColumnInfo(name = "symptoms_1")
//    val symptoms1: String?,
//    @ColumnInfo(name = "symptoms_2")
//    val symptoms2: String?,
//    @ColumnInfo(name = "symptoms_3")
//    val symptoms3: String?,
//    @ColumnInfo(name = "symptoms_4")
//    val symptoms4: String?,
//    @ColumnInfo(name = "symptoms_5")
//    val symptoms5: String?,

)
