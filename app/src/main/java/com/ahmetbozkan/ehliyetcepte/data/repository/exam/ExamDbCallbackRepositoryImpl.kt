package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import android.content.Context
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamHolder
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.util.Constants.EXAMS_FILE_NAME
import com.ahmetbozkan.ehliyetcepte.util.extension.getJsonDataFromFile
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ExamDbCallbackRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): ExamDbCallbackRepository {

    override fun getExamEntities(): List<Exam> {
        val exams = parseExamFile()

        val examEntityList = mutableListOf<Exam>()
        exams.forEach { exam ->
            examEntityList.add(exam.toEntityModel())
        }

        return examEntityList
    }

    override fun getQuestionEntities(): List<Question> {
        val exams = parseExamFile()

        val questions = mutableListOf<Question>()
        exams.forEachIndexed { index, exam ->
            exam.questions.forEach { question ->
                questions.add(
                    question.toEntityModel(
                        examId =(index + 1).toLong()
                    )
                )
            }
        }

        return questions
    }

    private fun parseExamFile(): List<ExamHolder> {
        val exams = getJsonDataFromFile(context, EXAMS_FILE_NAME)

        val gson = Gson()
        val examListType = object : TypeToken<List<ExamHolder>>() {}.type

        return gson.fromJson(exams, examListType)
    }

}