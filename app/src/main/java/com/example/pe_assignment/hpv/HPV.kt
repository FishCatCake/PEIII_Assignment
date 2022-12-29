package com.example.pe_assignment.hpv

import androidx.room.*
import com.example.pe_assignment.User
import java.util.Date

@Entity(tableName = "hpv_table")
data class HPV(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "Review_Year")
    val ReviewYear: String,

    @ColumnInfo(name = "Review_Month")
    val ReviewMonth: String,

    @ColumnInfo(name = "Review_day")
    val Reviewday: String,

    @ColumnInfo(name = "First_Dose_Year")
    val Dose1Year: String,

    @ColumnInfo(name = "First_Dose_Month")
    val Dose1Month: String,

    @ColumnInfo(name = "First_Dose_day")
    val Dose1day: String,

    @ColumnInfo(name = "Second_Dose_Year")
    val Dose2Year: String,

    @ColumnInfo(name = "Second_Dose_Month")
    val Dose2Month: String,

    @ColumnInfo(name = "Third_Dose_day")
    val Dose2day: String,

    @ColumnInfo(name = "Third_Dose_Year")
    val Dose3Year: String,

    @ColumnInfo(name = "Third_Dose_Month")
    val Dose3Month: String,

    @ColumnInfo(name = "Third_Dose_day")
    val Dose3day: String,

    @ColumnInfo(name = "uid")
    val uid: String
)