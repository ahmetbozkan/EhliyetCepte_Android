package com.ahmetbozkan.ehliyetcepte.data.datasource

import com.ahmetbozkan.ehliyetcepte.base.BaseDataSource
import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDao
import javax.inject.Inject

class ResultDataSource @Inject constructor(
    private val dao: ExamDao
): BaseDataSource() {

    suspend fun getExamWithQuestionsAndResult(examId: Long) =
        handleOperation {
            dao.getExamWithQuestionsAndResult(examId)
        }

}