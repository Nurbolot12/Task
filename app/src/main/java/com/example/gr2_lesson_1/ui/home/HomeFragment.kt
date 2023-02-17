package com.example.gr2_lesson_1.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gr2_lesson_1.R
import com.example.gr2_lesson_1.databinding.FragmentHomeBinding
import com.example.gr2_lesson_1.ui.home.new_task.NewTaskFragment.Companion.TASK_KEY
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

        setFragmentResultListener(TASK_KEY,) { _, bundle ->
            Log.e("ololo", "initViews: "+bundle.getString("title") + bundle.getString("desc"))

            var title = bundle.getString("title")
            var desc = bundle.getString("desc")

            taskAdapter.addTask(TaskModel(title, desc
            ))

        }
    }
}
