package com.example.gr2_lesson_1

import android.app.Application
import com.example.gr2_lesson_1.database.local.TaskDatabase
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            this,
            TaskDatabase::class.java,
            "database"
        )
            .allowMainThreadQueries()
            .build()

    }
        companion object{
            lateinit var db: TaskDatabase

    }
}

