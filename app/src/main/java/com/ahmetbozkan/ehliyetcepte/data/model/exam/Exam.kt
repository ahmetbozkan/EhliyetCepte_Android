package com.ahmetbozkan.ehliyetcepte.data.model.exam

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "exams")
data class Exam(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exam_id") val examId: Long = 0,
    @ColumnInfo(name = "name")  val name: String,
    @ColumnInfo(name = "category")  val category: ExamCategories,
    @ColumnInfo(name = "is_solved") val isSolved: Boolean = false,
    @ColumnInfo(name = "solved_date") val solvedDate: Long = 0
) : Parcelable
