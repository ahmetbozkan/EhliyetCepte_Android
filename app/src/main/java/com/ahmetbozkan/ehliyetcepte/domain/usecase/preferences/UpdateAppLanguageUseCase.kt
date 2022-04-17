package com.ahmetbozkan.ehliyetcepte.domain.usecase.preferences

import com.ahmetbozkan.ehliyetcepte.data.repository.preferences.PreferencesManagerRepository
import javax.inject.Inject

class UpdateAppLanguageUseCase @Inject constructor(
    private val repository: PreferencesManagerRepository
) {

    suspend operator fun invoke(language: String) =
        repository.updateAppLanguage(language = language)

}