package com.example.pe_assignment.database.entity

import androidx.room.*

@Entity(tableName = "user_cancer_phrase_table")
data class UserCancerPhrase(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "phrase")
    val phrase: String,

    @ColumnInfo(name = "uid")
    val uid: String
)