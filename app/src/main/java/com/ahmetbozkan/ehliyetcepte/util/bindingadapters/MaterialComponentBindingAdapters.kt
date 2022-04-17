package com.ahmetbozkan.ehliyetcepte.util.bindingadapters

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.button.MaterialButton

@BindingAdapter("strokeColorNonNull")
fun setStrokeColor(view: MaterialButton, @ColorRes color: Int?) {
    color?.let {
        view.strokeColor = ContextCompat.getColorStateList(view.context, it)
        view.strokeWidth = 1
    }
}

@BindingAdapter("textColorNonNull")
fun setTextColor(view: MaterialButton, @ColorRes color: Int?) {
    color?.let {
        view.setTextColor(
            ContextCompat.getColorStateList(view.context, it)
        )
    }
}