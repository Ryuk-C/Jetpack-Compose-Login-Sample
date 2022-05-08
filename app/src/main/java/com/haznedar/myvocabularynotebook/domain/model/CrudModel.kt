package com.haznedar.myvocabularynotebook.domain.model
import com.google.gson.annotations.SerializedName

data class CrudModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Int
)