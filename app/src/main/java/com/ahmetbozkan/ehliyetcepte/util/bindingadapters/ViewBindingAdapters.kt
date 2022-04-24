package com.ahmetbozkan.ehliyetcepte.util.bindingadapters

import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.util.extension.gone
import com.ahmetbozkan.ehliyetcepte.util.extension.invisible
import com.ahmetbozkan.ehliyetcepte.util.extension.visible

@BindingAdapter(value = ["isVisible", "gone"], requireAll = false)
fun setVisibility(view: View, isVisible: Boolean, gone: Boolean?) {
    if (isVisible) view.visible() else {
        if (gone == true) view.gone() else view.invisible()
    }
}

@BindingAdapter("viewBackgroundTint")
fun setBackgroundTint(view: View, @ColorRes tint: Int?) {
    val backgroundTint = tint?.let {
        ContextCompat.getColorStateList(view.context, it)
    } ?: ContextCompat.getColorStateList(view.context, R.color.white)

    view.backgroundTintList = backgroundTint
}