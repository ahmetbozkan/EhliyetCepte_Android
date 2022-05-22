package com.ahmetbozkan.ehliyetcepte.data.repository.question

import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDao
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val dao: ExamDao
) : QuestionRepository {

    override suspend fun insert(question: WrongQuestion) {
        dao.insert(question)
    }

    override suspend fun insert(questions: List<WrongQuestion>) {
        dao.insert(*questions.toTypedArray())
    }
}