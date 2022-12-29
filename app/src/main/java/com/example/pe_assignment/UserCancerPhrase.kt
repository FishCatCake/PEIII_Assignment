package com.example.pe_assignment

import androidx.room.*
import com.example.pe_assignment.User

@Entity(tableName = "user_cancer_phrase_table",
    foreignKeys = [ForeignKey(
        entity = User::class,
        childColumns = arrayOf("uid"),
        parentColumns = arrayOf("name")
    )],
    indices = [Index(value = ["uid"], unique = true)]
)
//@Entity(tableName = "user_cancer_phrase_table")
data class UserCancerPhrase(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "phrase")
    val phrase: String,

    @ColumnInfo(name = "uid")
    val uname: String
)