package com.ahmetbozkan.ehliyetcepte.data.db.exam

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question

@Dao
interface ExamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg exam: Exam)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exam: Exam)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg question: Question)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(question: Question)

    @Transaction
    @Query("SELECT * FROM exams WHERE category = :category")
    fun getExamsWithCategory(category: ExamCategories): List<ExamWithQuestions>

    @Query("SELECT COUNT(name) FROM exams")
    fun getExamCount(): LiveData<Int>

}