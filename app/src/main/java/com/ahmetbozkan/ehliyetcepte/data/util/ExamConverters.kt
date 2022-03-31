package com.ahmetbozkan.ehliyetcepte.data.util

import androidx.room.TypeConverter
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options

class ExamConverters {

    /**
     * converters of the ExamCategories enum in Exams database
     */
    @TypeConverter
    fun toCategory(value: Int?) = enumValues<ExamCategories>()[value ?: 0]

    @TypeConverter
    fun fromCategory(value: ExamCategories?) = value?.ordinal ?: 0



}