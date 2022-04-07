package com.ahmetbozkan.ehliyetcepte

import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.domain.exam.GetExamCountUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getExamCountUseCase: GetExamCountUseCase
) : BaseViewModel() {

    val examCount = getExamCountUseCase.invoke()

}