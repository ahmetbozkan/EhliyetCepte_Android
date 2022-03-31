package com.ahmetbozkan.ehliyetcepte.di

import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamDbCallbackRepository
import com.ahmetbozkan.ehliyetcepte.data.repository.exam.ExamDbCallbackRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SingletonBinds {

    @Binds
    @Singleton
    abstract fun bindExamDbCallbackRepository(repositoryImpl: ExamDbCallbackRepositoryImpl): ExamDbCallbackRepository

}