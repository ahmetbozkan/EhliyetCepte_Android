package com.ahmetbozkan.ehliyetcepte.util.extension

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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

fun <T> parseJsonDataToList(context: Context, fileName: String): List<T> {
    val exams = getJsonDataFromFile(context, fileName)

    val gson = Gson()
    val examListType = object : TypeToken<List<T>>() {}.type

    return gson.fromJson(exams, examListType)
}