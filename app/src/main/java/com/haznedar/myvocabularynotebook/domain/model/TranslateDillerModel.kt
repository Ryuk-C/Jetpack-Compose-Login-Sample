package com.haznedar.kelimedefterim.model


import com.google.gson.annotations.SerializedName

data class TranslateDillerModel(
    @SerializedName("data")
    val `data`: Data
) {
    data class Data(
        @SerializedName("languages")
        val languages: List<Language>
    ) {
        data class Language(
            @SerializedName("language")
            val language: String,
            @SerializedName("name")
            val name: String
        )
    }
}