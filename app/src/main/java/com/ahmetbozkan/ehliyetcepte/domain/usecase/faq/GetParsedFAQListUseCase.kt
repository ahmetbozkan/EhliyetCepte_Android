package com.ahmetbozkan.ehliyetcepte.domain.usecase.faq

import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsDbCallbackRepository
import javax.inject.Inject

class GetParsedFAQListUseCase @Inject constructor(
    private val repository: UsefulTopicsDbCallbackRepository
) {

    val faqs = invoke()

    private operator fun invoke() = repository.getFrequentlyAskedQuestions()

}