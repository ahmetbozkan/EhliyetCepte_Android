package com.ahmetbozkan.ehliyetcepte.di

import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamRepositoryImpl
import com.ahmetbozkan.ehliyetcepte.data.repository.preferences.PreferencesManagerRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.preferences.PreferencesManagerRepositoryImpl
import com.ahmetbozkan.ehliyetcepte.data.repository.question.QuestionRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.question.QuestionRepositoryImpl
import com.ahmetbozkan.ehliyetcepte.data.repository.result.ResultRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.result.ResultRepositoryImpl
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

    @Binds
    @ViewModelScoped
    abstract fun bindExamRepository(repositoryImpl: ExamRepositoryImpl): ExamRepository

    @Binds
    @ViewModelScoped
    abstract fun bindResultRepository(repositoryImpl: ResultRepositoryImpl): ResultRepository

    @Binds
    @ViewModelScoped
    abstract fun bindQuestionRepository(repositoryImpl: QuestionRepositoryImpl): QuestionRepository

}