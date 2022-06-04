package com.ahmetbozkan.ehliyetcepte.data.model.usefultopics

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "exam_tips")
data class ExamTip(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Long = 0,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("tip_image_url") val imageUrl: String,
    @SerializedName("tip_type") val _type: Int
) {

    private val type
        get() = ExamTipTypes.getByValue(_type)

}

enum class ExamTipTypes(val value: Int) {
    WRITTEN_EXAM_TIP(1),
    DRIVING_EXAM_TIP(2),
    NONE(-1);

    companion object {
        private val VALUES = values()

        fun getByValue(value: Int) = VALUES.firstOrNull { it.value == value } ?: NONE
    }
}
