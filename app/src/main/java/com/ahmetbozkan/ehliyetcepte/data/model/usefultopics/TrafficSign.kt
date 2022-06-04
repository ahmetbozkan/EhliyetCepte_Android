package com.ahmetbozkan.ehliyetcepte.data.model.usefultopics

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "traffic_signs")
data class TrafficSign(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Long = 0,
    @SerializedName("description") val description: String,
    @SerializedName("image_url") val imageUrl: String
): Parcelable