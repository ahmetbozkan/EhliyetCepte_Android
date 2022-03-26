package com.ahmetbozkan.ehliyetcepte.data.db.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ahmetbozkan.ehliyetcepte.data.model.preferences.UserPreferences
import com.ahmetbozkan.ehliyetcepte.util.extension.handleException
import com.ahmetbozkan.ehliyetcepte.util.extension.userPrefsDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferencesManager @Inject constructor(@ApplicationContext context: Context) {

    private val userPrefsDataStore: DataStore<Preferences> = context.userPrefsDataStore

    val userPreferencesFlow = userPrefsDataStore.handleException()
        .map { preferences ->
            val language = preferences[APP_LANGUAGE] ?: Locale.getDefault().toString()

            UserPreferences(language = language)
        }

    suspend fun updateAppLanguage(language: String) {
        userPrefsDataStore.edit { preferences ->
            preferences[APP_LANGUAGE] = language
        }
    }

    companion object {
        private val APP_LANGUAGE = stringPreferencesKey("app_language")
    }
}