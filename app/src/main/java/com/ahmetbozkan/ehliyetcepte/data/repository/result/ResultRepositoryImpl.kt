package com.ahmetbozkan.ehliyetcepte.data.repository.result

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.datasource.ResultDataSource
import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDao
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.data.util.ResultMapper
import com.ahmetbozkan.ehliyetcepte.ui.result.SolvedExamEntity
import javax.inject.Inject

class ResultRepositoryImpl @Inject constructor(
    private val resultMapper: ResultMapper,
    private val dao: ExamDao,
    private val resultDataSource: ResultDataSource
) : ResultRepository {

    override fun mapSolvedExam(exam: SolvedExamEntity): Result =
        resultMapper.map(exam)

    override suspend fun insert(result: Result) {
        dao.insert(result)
    }

    override suspend fun getExamWithQuestionsAndResult(examId: Long): Resource<ExamWithQuestionsAndResult> =
        resultDataSource.getExamWithQuestionsAndResult(examId)

    override fun getAllResults(): LiveData<List<ExamWithQuestionsAndResult>> =
        dao.getAllResults()

    override fun getAllResults(category: ExamCategories): LiveData<List<ExamWithQuestionsAndResult>> =
        dao.getAllResults(category)


}