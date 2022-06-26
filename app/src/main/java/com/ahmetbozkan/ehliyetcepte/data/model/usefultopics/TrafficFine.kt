package com.ahmetbozkan.ehliyetcepte.data.model.usefultopics

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "traffic_fines")
data class TrafficFine(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @SerializedName("name") val name: String,
    @SerializedName("fine_total") val fineTotal: Double,
    @SerializedName("fine_discounted_25pc") val fineDiscounted25Pc: Double,
    @SerializedName("traffic_violation_point") val trafficViolationPoint: Int,
)
