package com.example.gr2_lesson_1.ui.onboard

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isVisible
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.gr2_lesson_1.R
import com.example.gr2_lesson_1.databinding.FragmentOnBoardBinding
import com.example.gr2_lesson_1.databinding.FragmentOnBoardPageBinding
import com.example.gr2_lesson_1.utils.Preferences


class OnBoardPageFragment(
    var listenersSkip: ()-> Unit,
    var listenersNext: ()-> Unit
):Fragment() {

    private lateinit var binding: FragmentOnBoardPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardPageBinding.inflate(inflater,container,false)

        initViews()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.btnStart.setOnClickListener{
            findNavController().navigateUp()
            Preferences(requireContext()).board = true
        }

        binding.btnSkip.setOnClickListener{
            listenersSkip.invoke()
        }
        binding.btnNext.setOnClickListener{
            listenersNext.invoke()
        }
    }

    private fun initViews() {
        arguments.let {
            val data = it?.getSerializable("onBoard") as BoardModel
            data.image?.let {it1 -> binding.imgBoard.setImageResource(it1)}
            binding.tvTitleBoard.text = data.title
            binding.tvDescBoard.text = data.desc

            binding.btnSkip.isVisible = data.isLast == false
            binding.btnNext.isVisible = data.isLast == false

            binding.btnStart.isVisible = data.isLast == true
        }

    }

}
