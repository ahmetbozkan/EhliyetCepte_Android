package com.ahmetbozkan.ehliyetcepte.domain.usecase.examtips

import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.ExamTip
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsDbCallbackRepository
import javax.inject.Inject

class GetParsedExamTipsListUseCase @Inject constructor(
    private val repository: UsefulTopicsDbCallbackRepository
) {

    val examTips = invoke()

    private operator fun invoke(): List<ExamTip> = repository.getExamTipsEntities()

}