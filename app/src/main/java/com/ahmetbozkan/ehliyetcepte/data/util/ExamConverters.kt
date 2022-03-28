package com.ahmetbozkan.ehliyetcepte.data.util

import androidx.room.TypeConverter
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options

class ExamConverters {

    /**
     * converters of the ExamCategories enum in Exams database
     */
    @TypeConverter
    fun toCategory(value: Int) = enumValues<ExamCategories>()[value]

    @TypeConverter
    fun fromCategory(value: ExamCategories) = value.ordinal

    /**
     * converters of the Options enum in Exams database
     */
    @TypeConverter
    fun toOption(value: Int) = enumValues<Options>()[value]

    @TypeConverter
    fun fromOption(value: Options) = value.ordinal

}