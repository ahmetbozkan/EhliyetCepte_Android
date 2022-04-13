package com.ahmetbozkan.ehliyetcepte.data.datasource

import com.ahmetbozkan.ehliyetcepte.base.BaseDataSource
import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDao
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import javax.inject.Inject

class ExamDataSource @Inject constructor(
    private val dao: ExamDao
) : BaseDataSource() {

    suspend fun getExams(category: ExamCategories) =
        handleOperation {
            dao.getExams(category)
        }

    suspend fun getExamWithQuestions(examId: Long) =
        handleOperation {
            dao.getExamWithQuestions(examId)
        }

    fun getExamCount() = dao.getExamCount()

}