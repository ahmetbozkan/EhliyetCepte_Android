package com.ahmetbozkan.ehliyetcepte.util.extension

import androidx.appcompat.widget.AppCompatImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.ahmetbozkan.ehliyetcepte.R
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.request.RequestOptions

fun AppCompatImageView.loadUrl(url: String?) {
    val circularProgressDrawable = CircularProgressDrawable(this.context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }

    val options: RequestOptions = RequestOptions()
        .placeholder(circularProgressDrawable)
        .error(R.drawable.ic_image_placeholder)
        .priority(Priority.HIGH)

    if (url.isNullOrBlank().not()) {
        Glide.with(this.context)
            .load(url)
            .apply(options)
            .into(this)

    }
}