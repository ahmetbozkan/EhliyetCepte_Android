package com.ahmetbozkan.ehliyetcepte.ui.scoreboard

import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.domain.usecase.result.GetAllResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScoreboardViewModel @Inject constructor(
    getAllResultsUseCase: GetAllResultsUseCase
) : BaseViewModel() {

    val results = getAllResultsUseCase.invoke()

}