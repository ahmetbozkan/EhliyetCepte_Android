package com.ahmetbozkan.ehliyetcepte.data.db.exam

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories

@Dao
interface ExamDao {

    @Transaction
    @Query("SELECT * FROM exams WHERE category = :category")
    fun getExamWithCategory(category: ExamCategories): List<Exam>

}