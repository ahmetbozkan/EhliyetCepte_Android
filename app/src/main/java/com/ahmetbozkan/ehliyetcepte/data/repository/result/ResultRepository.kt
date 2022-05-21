package com.ahmetbozkan.ehliyetcepte.data.repository.result

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.ui.result.SolvedExamEntity

interface ResultRepository {

    /**
     * map solved exam to a Result object to use it when inserting result to db
     * @param exam contains selected options and solved exam object
     * @return Result object contains correct, wrong & score
     */
    fun mapSolvedExam(exam: SolvedExamEntity): Result

    /**
     * insert result to db
     */
    suspend fun insert(result: Result)

    /**
     * get exam, questions and result of that exam with given examId
     * @param examId: id of Exam
     * @return ExamWithQuestionsAndResults object
     */
    suspend fun getExamWithQuestionsAndResult(examId: Long): Resource<ExamWithQuestionsAndResult>

    /**
     * get all the results from the db
     * @return results as liveData to get observable list
     */
    fun getAllResults(): LiveData<List<ExamWithQuestionsAndResult>>

    /**
     * get all the results from the db with given category
     * @return results as liveData to get observable list
     */
    fun getAllResults(category: ExamCategories): LiveData<List<ExamWithQuestionsAndResult>>

}