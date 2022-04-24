package com.ahmetbozkan.ehliyetcepte.util.bindingadapters

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.util.extension.gone

@BindingAdapter("imageDrawable")
fun setImageDrawable(view: AppCompatImageView, @DrawableRes image: Int?) {
    image?.let {
        view.setImageResource(it)
    } ?: view.gone()
}

@BindingAdapter("imageTint")
fun setVectorImageTint(view: AppCompatImageView, @ColorRes tint: Int?) {
    val imageTint = tint?.let {
        ContextCompat.getColorStateList(view.context, it)
    } ?: ContextCompat.getColorStateList(view.context, R.color.teal_700)

    view.imageTintList = imageTint
}