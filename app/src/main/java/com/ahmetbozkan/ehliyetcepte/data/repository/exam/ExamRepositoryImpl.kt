package com.ahmetbozkan.ehliyetcepte.data.repository.exam

import androidx.lifecycle.LiveData
import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDao
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import javax.inject.Inject

class ExamRepositoryImpl @Inject constructor(
    private val dao: ExamDao
) : ExamRepository {

    override fun getExamsWithCategory(category: ExamCategories): List<Exam> =
        dao.getExamsWithCategory(category)

    override fun getExamCount(): LiveData<Int> =
        dao.getExamCount()

}