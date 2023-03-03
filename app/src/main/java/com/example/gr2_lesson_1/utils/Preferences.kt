package com.example.gr2_lesson_1.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.gr2_lesson_1.R
import java.lang.Boolean.getBoolean

class Preferences(context: Context) {

    private val sharedPreference: SharedPreferences =
        context.getSharedPreferences("pref", Context.MODE_PRIVATE)

    var board: Boolean
        get() = sharedPreference.getBoolean("board", false)
        set(value) = sharedPreference.edit().putBoolean("board", value).apply()

    var imgProfile: String?
    get() = sharedPreference.getString("img", R.mipmap.ic_launcher.toString(),)
    set(value) = sharedPreference.edit().putString("img", value).apply()
}

