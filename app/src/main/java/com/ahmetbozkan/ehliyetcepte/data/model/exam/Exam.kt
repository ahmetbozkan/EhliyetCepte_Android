package com.ahmetbozkan.ehliyetcepte.data.model.exam

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "exams")
data class Exam(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exam_id") val examId: Long = 0,
    val name: String,
    val category: ExamCategories
): Parcelable
