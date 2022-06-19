package com.ahmetbozkan.ehliyetcepte.data.model.usefultopics

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "city_plates")
data class CityPlate(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val plate: String,
    val city: String
)
