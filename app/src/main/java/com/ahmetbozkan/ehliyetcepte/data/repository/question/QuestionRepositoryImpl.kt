package com.ahmetbozkan.ehliyetcepte.data.repository.question

import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.datasource.WrongQuestionDataSource
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(
    private val dataSource: WrongQuestionDataSource
) : QuestionRepository {

    override suspend fun insert(question: WrongQuestion) {
        dataSource.insert(question)
    }

    override suspend fun insert(questions: List<WrongQuestion>) {
        dataSource.insert(questions)
    }

    override suspend fun getAllWrongQuestions(): Resource<List<WrongQuestion>> =
        dataSource.getAllWrongQuestions()

}