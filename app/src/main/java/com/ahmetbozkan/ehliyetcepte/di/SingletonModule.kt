package com.ahmetbozkan.ehliyetcepte.di

import android.app.Application
import androidx.room.Room
import com.ahmetbozkan.ehliyetcepte.data.db.exam.ExamDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.annotation.Signed
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {

    @Provides
    @Singleton
    fun provideExamDatabase(
        application: Application,
        callback: ExamDatabase.Callback
    ) = Room.databaseBuilder(application, ExamDatabase::class.java, "exam_database")
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    @Singleton
    fun provideExamDao(database: ExamDatabase) = database.examDao()

    @Provides
    @Singleton
    @ApplicationScope
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope