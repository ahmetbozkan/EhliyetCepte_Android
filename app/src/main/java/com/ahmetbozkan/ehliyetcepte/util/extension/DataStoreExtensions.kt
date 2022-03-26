package com.ahmetbozkan.ehliyetcepte.util.extension

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import java.io.IOException

private const val TAG = "PREFERENCES DATA STORE"
private const val USER_PREFERENCES = "user_preferences"

val Context.userPrefsDataStore: DataStore<Preferences> by preferencesDataStore(USER_PREFERENCES)

fun DataStore<Preferences>.handleException(): Flow<Preferences> =
    this.data.catch { exception ->
        if (exception is IOException) {
            Log.e(TAG, "Error reading preferences. ", exception)
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }
