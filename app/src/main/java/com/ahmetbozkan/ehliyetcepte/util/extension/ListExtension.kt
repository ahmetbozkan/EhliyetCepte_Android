package com.ahmetbozkan.ehliyetcepte.util.extension

fun <T> List<T>.addCustomItemToFirstElement(element: T): List<T> {
    return listOf(element) + this
}