package com.ahmetbozkan.ehliyetcepte.data.model.result

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "results")
data class Result(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val correct: Int,
    val wrong: Int,
    val score: Int
)
