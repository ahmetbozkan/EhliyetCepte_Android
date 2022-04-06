package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question

interface ExamDbCallbackRepository {

    /**
     * get Exams as entity classes from parsed ExamHolder list to insert Room db
     */
    fun getExamEntities(): List<Exam>

    /**
     * get Exams as entity classes from parsed ExamHolder list to insert Room db
     */
    fun getQuestionEntities(): List<Question>
}