package com.ahmetbozkan.ehliyetcepte.domain.usecase.examtips

import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.ExamTipTypes
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsRepository
import javax.inject.Inject

class GetExamTipsUseCase @Inject constructor(
    private val repository: UsefulTopicsRepository
) {

    suspend operator fun invoke(type: ExamTipTypes) =
        repository.getExamTips(type)

}