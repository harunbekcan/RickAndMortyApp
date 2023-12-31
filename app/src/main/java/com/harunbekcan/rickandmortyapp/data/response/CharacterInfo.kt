package com.harunbekcan.rickandmortyapp.data.response

import com.google.gson.annotations.SerializedName

data class CharacterInfo(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("prev")
    val prev: Any?
)