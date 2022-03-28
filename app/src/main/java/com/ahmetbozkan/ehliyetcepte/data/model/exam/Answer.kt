package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "answers")
data class Answer(
    @ColumnInfo(name = "answer_id")
    @PrimaryKey(autoGenerate = true)
    val answerId: Long,
    val option: Options,
    @ColumnInfo(name = "option_full") val optionFull: String
)
