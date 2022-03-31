package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam

interface ExamDbCallbackRepository {

    /**
     * parse exams.json file to list of Exam objects to insert database in callback
     * @return list of exam objects
     */
    fun parseExamFile(): List<Exam>
}