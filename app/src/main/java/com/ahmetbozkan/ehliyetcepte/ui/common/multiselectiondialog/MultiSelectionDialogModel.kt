package com.ahmetbozkan.ehliyetcepte.ui.common.multiselectiondialog

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.ahmetbozkan.ehliyetcepte.util.extension.EMPTY
import kotlinx.parcelize.Parcelize

@Parcelize
data class MultiSelectionDialogModel(
    val title: String = String.EMPTY,
    val description: String = String.EMPTY,
    val rightButtonText: String = String.EMPTY,
    @ColorRes val rightButtonBgColor: Int? = null,
    @ColorRes val rightButtonTextColor: Int? = null,
    @ColorRes val rightButtonStrokeColor: Int? = null,
    val leftButtonText: String = String.EMPTY,
    @ColorRes val leftButtonBgColor: Int? = null,
    @ColorRes val leftButtonTextColor: Int? = null,
    @ColorRes val leftButtonStrokeColor: Int? = null,
    @DrawableRes val iconRes: Int? = null,
    @ColorRes val iconTint: Int? = null,
    val isLeftButtonVisible: Boolean = true
) : Parcelable {

    companion object {
        const val SINGLE_BUTTON_DIALOG_RETURN_KEY = "single_button"
        const val SINGLE_BUTTON_DIALOG_BUTTON_ACTION_KEY = "dialog_button_action"
    }

}

enum class MultiSelectionType(val value: Int) {
    NOTHING(-1),
    SELECTION_LEFT(0),
    SELECTION_RIGHT(1)
}
