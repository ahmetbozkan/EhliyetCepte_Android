package com.ahmetbozkan.ehliyetcepte.ui.common.examcategory

import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories

data class ExamCategory(
    val id: Int,
    val category: ExamCategories,
    var isSelected: Boolean = false
)
