package com.example.pe_assignment.database

import androidx.room.Database

@Database(entities = [User::class, Cycle::class, HPV::class, Cancer::class, Treatment::class], version = 1)
class AppDatabase {
}