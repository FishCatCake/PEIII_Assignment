package com.example.pe_assignment.database.entity

import androidx.room.*

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
    val FirstYear: String,

    @ColumnInfo(name = "First_Dose_Month")
    val FirstMonth: String,

    @ColumnInfo(name = "First_Dose_day")
    val Firstday: String,

    @ColumnInfo(name = "Second_Dose_Year")
    val SecondYear: String,

    @ColumnInfo(name = "Second_Dose_Month")
    val SecondMonth: String,

    @ColumnInfo(name = "Second_Dose_day")
    val Secondday: String,

    @ColumnInfo(name = "Third_Dose_Year")
    val ThirdYear: String,

    @ColumnInfo(name = "Third_Dose_Month")
    val ThirdMonth: String,

    @ColumnInfo(name = "Third_Dose_day")
    val Thirdday: String,

    @ColumnInfo(name = "uid")
    val uid: String
)