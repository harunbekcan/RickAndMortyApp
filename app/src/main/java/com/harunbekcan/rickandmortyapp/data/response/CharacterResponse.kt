package com.harunbekcan.rickandmortyapp.data.response

import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("info")
    val info: CharacterInfo,
    @SerializedName("results")
    val results: List<CharacterResult>?
)