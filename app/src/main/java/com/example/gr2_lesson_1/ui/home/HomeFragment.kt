package com.example.gr2_lesson_1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gr2_lesson_1.App
import com.example.gr2_lesson_1.R
import com.example.gr2_lesson_1.databinding.FragmentHomeBinding
import com.example.gr2_lesson_1.ui.home.new_task.TaskAdapter

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var taskAdapter: TaskAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initListeners()
    }

    private fun initListeners() {
        binding.fabHome.setOnClickListener {
            findNavController().navigate(R.id.navigation_new_task)
            findNavController().navigateUp()
        }

        fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
        }
    }

    private fun initViews() {
        binding.rvHome.layoutManager = LinearLayoutManager(context)
        binding.rvHome.adapter = taskAdapter
        setData()
        }

    private fun setData() {
        val listOfTask = App.db.dao()?.getAllTasks()
        taskAdapter.addTask(listOfTask as List<TaskModel>)
    }

    private fun getDataFromLocalDB(){
        val listOfTask = App.db.dao().getAllTasks()
        taskAdapter.addTasksFromRoom(listOfTask)
    }
}
