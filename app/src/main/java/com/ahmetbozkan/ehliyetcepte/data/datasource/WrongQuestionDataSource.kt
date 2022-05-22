package com.ahmetbozkan.ehliyetcepte.data.datasource

import com.ahmetbozkan.ehliyetcepte.base.BaseDataSource
import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDao
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import javax.inject.Inject

class WrongQuestionDataSource @Inject constructor(private val dao: ExamDao) : BaseDataSource() {

    suspend fun insert(question: WrongQuestion) {
        dao.insert(question)
    }

    suspend fun insert(questions: List<WrongQuestion>) {
        dao.insert(*questions.toTypedArray())
    }

    suspend fun getAllWrongQuestions() = handleOperation {
        dao.getAllWrongQuestions()
    }

}