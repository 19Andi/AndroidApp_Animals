package com.example.tema1_titescuandrei.helpers.extensions

import android.util.Log

fun String.logErrorMessage(tag: String = "Animals") {
    Log.e(tag, this)
}