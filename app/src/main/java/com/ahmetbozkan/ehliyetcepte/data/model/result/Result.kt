package com.ahmetbozkan.ehliyetcepte.data.model.result

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion

@Entity(tableName = "results")
data class Result @JvmOverloads constructor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id") val resultId: Long = 0,
    @ColumnInfo(name = "parent_exam_id") val parentExamId: Long,
    @ColumnInfo(name = "correct") val correct: Int,
    @ColumnInfo(name = "wrong") val wrong: Int,
    @ColumnInfo(name = "score") val score: Int,
    @ColumnInfo(name = "duration") val duration: String,
) {
    @Ignore
    var wrongQuestions: List<WrongQuestion> = listOf()
}
