package com.ahmetbozkan.ehliyetcepte.util.extension

fun String?.orEmpty() = this ?: String.EMPTY

fun Int?.orZero() = this ?: 0

fun Long?.orZero() = this ?: 0L

fun Double?.orZero() = this ?: 0.0