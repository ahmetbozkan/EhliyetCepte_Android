package com.ahmetbozkan.ehliyetcepte.data.db.exam

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Answer
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.data.util.ExamConverters
import com.ahmetbozkan.ehliyetcepte.di.ApplicationScope
import com.ahmetbozkan.ehliyetcepte.domain.exam.ParseExamsFileUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Exam::class, Question::class, Answer::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ExamConverters::class)
abstract class ExamDatabase : RoomDatabase() {

    abstract fun examDao(): ExamDao

    class Callback @Inject constructor(
        private val database: Provider<ExamDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope,
        private val useCase: ParseExamsFileUseCase
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().examDao()
            val exams: List<Exam> = useCase.exams

            applicationScope.launch {
                dao.insert(*exams.toTypedArray())
            }
        }

    }
}