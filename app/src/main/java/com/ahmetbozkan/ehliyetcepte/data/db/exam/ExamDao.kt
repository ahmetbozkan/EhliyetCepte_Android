package com.ahmetbozkan.ehliyetcepte.data.db.exam

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.data.model.result.Result

@Dao
interface ExamDao {

    /**
     * EXAM
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg exam: Exam)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(exam: Exam)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(exam: Exam)

    @Transaction
    @Query("SELECT * FROM exams WHERE category = :category")
    suspend fun getExams(category: ExamCategories): List<Exam>

    @Transaction
    @Query("SELECT * FROM exams WHERE exam_id = :examId")
    suspend fun getExamWithQuestions(examId: Long): ExamWithQuestions

    @Query("SELECT COUNT(name) FROM exams")
    fun getExamCount(): LiveData<Int>

    /**
     * QUESTION
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg question: Question)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(question: Question)

    /**
     * RESULT
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(result: Result)

    @Transaction
    @Query("SELECT * FROM exams WHERE exam_id = :examId")
    suspend fun getExamWithQuestionsAndResult(examId: Long): ExamWithQuestionsAndResult

}