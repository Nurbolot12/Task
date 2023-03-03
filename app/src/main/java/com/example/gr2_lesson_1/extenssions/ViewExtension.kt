package com.example.gr2_lesson_1.extenssions

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String){
    Glide
        .with(this)
        .load(url)
        .circleCrop()
        .into(this);
}

fun Fragment.snowToast(msg: String){
    Toast.makeText(requireContext(), "msg", Toast.LENGTH_SHORT).show()

}