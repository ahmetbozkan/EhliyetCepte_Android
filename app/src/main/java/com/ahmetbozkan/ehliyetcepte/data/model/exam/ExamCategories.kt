package com.ahmetbozkan.ehliyetcepte.data.model.exam

enum class ExamCategories(val value: Int) {
    ALL(0),
    PILOT(1),
    SHORT(2),
    TRAFFIC_SIGNS(3),
    TRAFFIC(4),
    ENGINE(5),
    FIRST_AID(6),
    TRAFFIC_MANNERS(7);

    companion object {
        private val VALUES = values()
        fun getByValue(value: Int) = VALUES.firstOrNull { it.value == value } ?: ALL
    }
}