package com.example.firstcompose.models

import com.google.gson.annotations.SerializedName

data class TweetDto(
    @SerializedName("category")
    val category: String,

    @SerializedName("text")
    val text: String
)