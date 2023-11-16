package com.harunbekcan.rickandmortyapp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageCircle(url: String?) {
    Glide.with(this)
        .load(url)
        .fitCenter()
        .circleCrop()
        .into(this)
}