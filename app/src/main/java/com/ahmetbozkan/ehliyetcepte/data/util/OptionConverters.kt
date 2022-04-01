package com.ahmetbozkan.ehliyetcepte.data.util

import androidx.room.TypeConverter
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options

class OptionConverters {

    /**
     * converters of the ExamCategories enum in Exams database
     */
    @TypeConverter
    fun toOption(value: Int?) = enumValues<Options>()[value ?: 0]

    @TypeConverter
    fun fromOption(value: Options?) = value?.ordinal ?: 0

}