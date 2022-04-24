package com.ahmetbozkan.ehliyetcepte.ui.result

import android.os.Parcelable
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import kotlinx.parcelize.Parcelize

@Parcelize
data class SolvedExamEntity(
    val examId: Long,
    val answers: Map<Long, Options>,
    val examWithQuestions: ExamWithQuestions
) : Parcelable
