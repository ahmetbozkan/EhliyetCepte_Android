package com.ahmetbozkan.ehliyetcepte.data.repository.preferences

import com.ahmetbozkan.ehliyetcepte.data.db.preferences.PreferencesManager
import com.ahmetbozkan.ehliyetcepte.data.model.preferences.UserPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PreferencesManagerRepositoryImpl @Inject constructor(
    private val manager: PreferencesManager
): PreferencesManagerRepository {

    override val userPrefsFlow: Flow<UserPreferences> = manager.userPreferencesFlow

    override suspend fun updateAppLanguage(language: String) {
        manager.updateAppLanguage(language)
    }
}