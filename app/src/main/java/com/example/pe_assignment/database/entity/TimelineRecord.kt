package com.example.pe_assignment.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cancer_timeline")
data class TimelineRecord(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "Year")
    val Year: String,

    @ColumnInfo(name = "Month")
    val Month: String,

    @ColumnInfo(name = "dateofMonth")
    val dateofMonth: String,

    @ColumnInfo(name = "Title")
    val Title: String,

    @ColumnInfo(name = "Description")
    val Description: String,

    @ColumnInfo(name = "File")
    val File: String,

    @ColumnInfo(name = "uid")
    val uid: String
)