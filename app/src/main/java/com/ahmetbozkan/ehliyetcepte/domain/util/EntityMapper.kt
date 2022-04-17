package com.ahmetbozkan.ehliyetcepte.domain.util

interface EntityMapper<in T, out V> {

    fun map(from: T): V
}