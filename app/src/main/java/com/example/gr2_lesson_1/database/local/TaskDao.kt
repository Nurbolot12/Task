package com.example.gr2_lesson_1.database.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.gr2_lesson_1.ui.home.TaskModel

@Dao
interface TaskDao {

    @Insert
    fun insert(task: TaskModel)

    @Query("SELECT * FROM TaskModel")
    fun getAllTasks(): List<TaskModel>

    @Query("SELECT * FROM TaskModel ORDER BY title DESC")
    fun getAllTasksByAlphabetAZ(): List<TaskModel>
}