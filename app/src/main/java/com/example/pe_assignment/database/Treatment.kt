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
data class Treatment(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
