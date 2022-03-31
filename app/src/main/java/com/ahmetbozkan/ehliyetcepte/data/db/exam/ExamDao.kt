package com.ahmetbozkan.ehliyetcepte.data.db.exam

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestionsAndAnswers

@Dao
interface ExamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg exam: Exam)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exam: Exam)

    @Transaction
    @Query("SELECT * FROM exams WHERE category = :category")
    fun getExamsWithCategory(category: ExamCategories): LiveData<List<ExamWithQuestionsAndAnswers>>

    @Query("SELECT COUNT(name) FROM exams")
    fun getExamCount(): LiveData<Int>

}