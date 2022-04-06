package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions

interface ExamRepository {

    /**
     * get all the exams with the given category from Exams database
     * @param category of the Exams
     * @return list of Exams as LiveData
     */
    fun getExamsWithCategory(category: ExamCategories): List<ExamWithQuestions>

    /**
     * get exam count in the Exams database
     * this method will be used to invoke Exam database callback and determine if all the exams are inserted to db
     * @return count of the Exams as Integer type wrapped into LiveData
     */
    fun getExamCount(): LiveData<Int>

}