package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.datasource.ExamDataSource
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import javax.inject.Inject

class ExamRepositoryImpl @Inject constructor(
    private val dataSource: ExamDataSource
) : ExamRepository {

    override suspend fun getExams(category: ExamCategories): Resource<List<Exam>> =
        dataSource.getExams(category)

    override suspend fun getExamWithQuestions(examId: Long): Resource<ExamWithQuestions> =
        dataSource.getExamWithQuestions(examId)

    override fun getExamCount(): LiveData<Int> =
        dataSource.getExamCount()

    override suspend fun update(exam: Exam) {
        dataSource.update(exam)
    }

}