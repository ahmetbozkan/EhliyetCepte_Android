package com.ahmetbozkan.ehliyetcepte.data.model.exam

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "answers")
data class Answer(
    @PrimaryKey(autoGenerate = true)
    val answerId: Long,
    val option: Options,
    @SerializedName("option_full") val optionFull: String
)
