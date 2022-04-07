package com.ahmetbozkan.ehliyetcepte.ui.examlist

import androidx.lifecycle.liveData
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamsWithCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ExamListViewModel @Inject constructor(
    private val getExamsWithCategoryUseCase: GetExamsWithCategoryUseCase
): BaseViewModel() {

    fun getExams(category: ExamCategories) =
        liveData(Dispatchers.IO + genericExceptionHandler) {
            emit(getExamsWithCategoryUseCase.invoke(category))
        }

}