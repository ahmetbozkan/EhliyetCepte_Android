package com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "vehicle_gauges")
data class VehicleGauge(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Long = 0,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String
) : Parcelable
