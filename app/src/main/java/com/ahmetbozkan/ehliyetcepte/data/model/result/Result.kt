package com.ahmetbozkan.ehliyetcepte.data.model.result

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class Result(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id") val resultId: Long = 0,
    @ColumnInfo(name = "parent_exam_id") val parentExamId: Long,
    @ColumnInfo(name = "correct") val correct: Int,
    @ColumnInfo(name = "wrong") val wrong: Int,
    @ColumnInfo(name = "score") val score: Int,
    @ColumnInfo(name = "duration") val duration: String
)
