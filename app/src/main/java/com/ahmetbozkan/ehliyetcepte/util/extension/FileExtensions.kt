package com.ahmetbozkan.ehliyetcepte.util.extension

import android.content.Context
import java.io.IOException

fun getJsonDataFromFile(context: Context, fileName: String): String? {
    val value: String

    try {
        value = context.assets.open(fileName).bufferedReader().use {
            it.readText()
        }
    } catch (exception: IOException) {
        exception.printStackTrace()
        return null
    }

    return value
}