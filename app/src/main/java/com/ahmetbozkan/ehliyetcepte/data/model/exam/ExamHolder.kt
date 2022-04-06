package com.ahmetbozkan.ehliyetcepte.data.model.exam

import com.google.gson.annotations.SerializedName

data class ExamHolder(
    val name: String,
    val category: Int,
    val questions: List<QuestionHolder>
) {
    fun toEntityModel(): Exam =
        Exam(name = name, category = ExamCategories.getByValue(category))
}

data class QuestionHolder(
    val question: String,
    @SerializedName("question_image_url") val imageUrl: String,
    @SerializedName("correct_option") val correctOption: String,
    val answers: List<AnswerHolder>
) {
    fun toEntityModel(examId: Long): Question {
        val answers = mutableListOf<Answer>()

        this.answers.forEach { answer ->
            answers.add(answer.toEntityModel())
        }

        return Question(
            parentExamId = examId,
            question = question,
            imageUrl = imageUrl,
            correctOption = Options.valueOf(correctOption),
            answers = answers
        )
    }
}

data class AnswerHolder(
    val option: String,
    @SerializedName("option_full") val optionFull: String
) {
    fun toEntityModel(): Answer =
        Answer(
            option = Options.valueOf(option),
            optionFull = optionFull
        )
}
