package com.android.mvvmexample.data.model

import com.google.gson.annotations.SerializedName

data class PhraseModel(
    @SerializedName("quote") val phrase: String,
    @SerializedName("author") val author: String
)
