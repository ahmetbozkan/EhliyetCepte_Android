package com.ahmetbozkan.ehliyetcepte.di

import com.ahmetbozkan.ehliyetcepte.data.repository.preferences.PreferencesManagerRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.preferences.PreferencesManagerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryBinds {

    @Binds
    @ViewModelScoped
    abstract fun bindPreferencesManagerRepository(repositoryImpl: PreferencesManagerRepositoryImpl): PreferencesManagerRepository

}