package com.ahmetbozkan.ehliyetcepte.data.repository.preferences

import com.ahmetbozkan.ehliyetcepte.data.model.preferences.UserPreferences
import kotlinx.coroutines.flow.Flow

interface PreferencesManagerRepository {

    /**
     * get UserSettings retrieved from Preferences DataStore as Flow objects
     */
    val userPrefsFlow: Flow<UserPreferences>

    /**
     * update app language and save it into the UserPrefs object stored in DataStore
     * @param language used to be update
     */
    suspend fun updateAppLanguage(language: String)

}