package com.example.gr2_lesson_1.ui.home.new_task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gr2_lesson_1.databinding.TaskItemBinding
import com.example.gr2_lesson_1.ui.home.TaskModel

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.TaskHolder>() {

    private var taskList = arrayListOf<TaskModel>()

    fun addTask(taskModel: List<TaskModel>){
        taskList.clear()
        taskList.addAll(taskModel)
        notifyDataSetChanged()
    }

    fun addTasksFromRoom(list: List<TaskModel>){
        taskList = list as ArrayList<TaskModel>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
        return TaskHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
        holder.bind(taskList[position])
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
    inner class TaskHolder(private var binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(taskModel: TaskModel) {
            binding.tvTitle.text = taskModel.title
            binding.tvDescItem.text = taskModel.desc

        }
    }


}
