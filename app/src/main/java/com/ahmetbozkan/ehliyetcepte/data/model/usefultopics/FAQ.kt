package com.ahmetbozkan.ehliyetcepte.data.model.usefultopics

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "frequently_asked_questions")
data class FAQ(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val question: String,
    val answer: String
)
