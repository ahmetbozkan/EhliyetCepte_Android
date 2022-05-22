package com.ahmetbozkan.ehliyetcepte.data.db.exam

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.data.util.AnswerConverters
import com.ahmetbozkan.ehliyetcepte.di.ApplicationScope
import com.ahmetbozkan.ehliyetcepte.domain.usecase.exam.GetParsedExamListUseCase
import com.ahmetbozkan.ehliyetcepte.domain.usecase.exam.GetParsedQuestionListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(
    entities = [Exam::class, Question::class, Result::class, WrongQuestion::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [AnswerConverters::class])
abstract class ExamDatabase : RoomDatabase() {

    abstract fun examDao(): ExamDao

    class Callback @Inject constructor(
        private val database: Provider<ExamDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope,
        private val getExamListUseCase: GetParsedExamListUseCase,
        private val getQuestionListUseCase: GetParsedQuestionListUseCase
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().examDao()

            val exams: List<Exam> = getExamListUseCase.exams
            val question: List<Question> = getQuestionListUseCase.questions

            applicationScope.launch {
                dao.insert(*exams.toTypedArray())
                dao.insert(*question.toTypedArray())
            }
        }
    }
}