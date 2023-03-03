package com.example.gr2_lesson_1.database.local

import androidx.room.Database
import com.example.gr2_lesson_1.ui.home.TaskModel

@Database(entities = [TaskModel::class], version = 1)
abstract class TaskDatabase {
    abstract fun dao(): TaskDao
}