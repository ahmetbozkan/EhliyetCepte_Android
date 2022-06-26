package com.ahmetbozkan.ehliyetcepte.domain.usecase.faq

import com.ahmetbozkan.ehliyetcepte.core.Resource
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.FAQ
import com.ahmetbozkan.ehliyetcepte.data.repository.usefultopics.UsefulTopicsRepository
import javax.inject.Inject

class GetFAQUseCase @Inject constructor(
    private val repository: UsefulTopicsRepository
) {

    suspend operator fun invoke(): Resource<List<FAQ>> =
        repository.getFrequentlyAskedQuestions()

}