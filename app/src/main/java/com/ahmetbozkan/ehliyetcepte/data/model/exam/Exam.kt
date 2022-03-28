package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exams")
data class Exam(
    @ColumnInfo(name = "exam_id")
    @PrimaryKey(autoGenerate = true)
    val examId: Long,
    val name: String,
    val category: ExamCategories
)
