package com.ahmetbozkan.ehliyetcepte.data.repository.question

import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion

interface QuestionRepository {

    /**
     * insert wrong questions to db
     */
    suspend fun insert(question: WrongQuestion)

    /**
     * insert wrong questions to db
     */
    suspend fun insert(question: List<WrongQuestion>)

    /**
     * get all wrong questions for solving later
     * @return list of WrongQuestions wrapped in resource
     */
    suspend fun getAllWrongQuestions(): Resource<List<WrongQuestion>>

}