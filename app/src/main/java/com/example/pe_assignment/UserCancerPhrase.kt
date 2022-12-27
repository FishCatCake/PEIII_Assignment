package com.example.pe_assignment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.pe_assignment.User

@Entity(tableName = "user_cancer_phrase_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        childColumns = arrayOf("uid"),
        parentColumns = arrayOf("id")
    )]
)

data class UserCancerPhrase(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "phrase")
    val phrase: String,

    @ColumnInfo(name = "uid", index = true)
    val uid: Long
)