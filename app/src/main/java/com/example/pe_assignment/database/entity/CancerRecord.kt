package com.example.pe_assignment.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "cancer_record")
data class CancerRecord(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "Year")
    val Year: String,

    @ColumnInfo(name = "Month")
    val Month: String,

    @ColumnInfo(name = "dateofMonth")
    val dateofMonth: String,

    @ColumnInfo(name = "Time")
    val Time: String,

    @ColumnInfo(name = "Symptom")
    val Symptom: String,

    @ColumnInfo(name = "SymptomAddition")
    val SymptomAddition: String,

    @ColumnInfo(name = "uid")
    val uid: String
)