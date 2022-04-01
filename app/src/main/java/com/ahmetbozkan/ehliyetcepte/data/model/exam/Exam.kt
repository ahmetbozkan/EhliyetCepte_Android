package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exams")
data class Exam(
    @PrimaryKey(autoGenerate = true)
    val examId: Long,
    val name: String,
    val category: ExamCategories
)
