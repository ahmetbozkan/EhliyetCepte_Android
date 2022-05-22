package com.ahmetbozkan.ehliyetcepte.data.repository.question

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

}