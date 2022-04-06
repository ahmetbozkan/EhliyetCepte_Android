package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exams")
data class Exam(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exam_id") val examId: Long = 0,
    val name: String,
    val category: ExamCategories
)
