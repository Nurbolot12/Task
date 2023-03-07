package com.example.gr2_lesson_1.ui.home.new_task

import android.os.Bundle
import com.example.gr2_lesson_1.databinding.FragmentHomeBinding
import com.example.gr2_lesson_1.databinding.FragmentNewTaskBinding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.gr2_lesson_1.App
import com.example.gr2_lesson_1.ui.home.TaskModel
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.logging.Log


class NewTaskFragment : Fragment() {

    private lateinit var binding: FragmentNewTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewTaskBinding.inflate(inflater, container, false)
        initListeners()
        return binding.root
    }

    private fun initListeners() {
        binding.btnSave.setOnClickListener {
            setFragmentResult(
                TASK_KEY, bundleOf(
                    "title" to binding.etTitle.text.toString(),
                    "desc" to binding.etDesc.text.toString()
                )
            )

            App.db.dao().insert(
                TaskModel(
                        title = binding.etTitle.text.toString(),
                        desc = binding.etDesc.text.toString()
                    )
                )
            findNavController ().navigateUp()
        }

    }


    companion object {
        const val TASK_KEY = "new task"
    }
}