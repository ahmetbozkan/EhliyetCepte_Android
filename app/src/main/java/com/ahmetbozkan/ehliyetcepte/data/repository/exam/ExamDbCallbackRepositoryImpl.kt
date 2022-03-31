package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import android.content.Context
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.util.Constants.EXAMS_FILE_NAME
import com.ahmetbozkan.ehliyetcepte.util.extension.getJsonDataFromFile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ExamDbCallbackRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): ExamDbCallbackRepository {

    override fun parseExamFile(): List<Exam> {
        val exams = getJsonDataFromFile(context, EXAMS_FILE_NAME)

        val gson = Gson()
        val examListType = object : TypeToken<List<Exam>>() {}.type

        return gson.fromJson(exams, examListType)
    }


}