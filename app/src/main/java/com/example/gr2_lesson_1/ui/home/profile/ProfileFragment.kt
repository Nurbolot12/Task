package com.example.gr2_lesson_1.ui.home.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore.Audio.Media
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContentProviderCompat.requireContext
import com.bumptech.glide.Glide
import com.example.gr2_lesson_1.R
import com.example.gr2_lesson_1.databinding.FragmentNewTaskBinding
import com.example.gr2_lesson_1.databinding.FragmentProfileBinding
import com.example.gr2_lesson_1.extenssions.loadImage
import com.example.gr2_lesson_1.utils.Preferences

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private val selectImageFromGalleryResult = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            Log.e("ololo", "Photo url = : $uri")
            binding.imgProfile.setImageURI(uri)

            showToast("Success!")
            binding.imgProfile.loadImage(uri.toString())

            Preferences(requireContext()).imgProfile = uri.toString()
        }
    }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        initViews()
        initListeners()

        return binding.root
    }

    private fun initListeners() {
        binding.imgProfile.setOnClickListener {
            selectImageFromGalleryResult.launch("image/*")
        }
    }

    private fun initViews() {
        var imgProfile = Preferences(requireContext()).imgProfile.toString()

        binding.imgProfile.loadImage(
        showToast("imgProfile")
    }

