package com.haznedar.kelimedefterim.model

import com.google.gson.annotations.SerializedName

data class TranslateDonutModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("messages")
    val messages: String,
    @SerializedName("info")
    val info: Int
) {
    data class Data(
        @SerializedName("translations")
        val translations: List<Translation>
    ) {
        data class Translation(
            @SerializedName("translatedText")
            val translatedText: String,
            @SerializedName("detectedSourceLanguage")
            val detectedSourceLanguage: String,
        )
    }
}

/*
data class TranslateDonutModel(
    @SerializedName("translations")
    val translateJSON: List<TranslateJSON>,
    @SerializedName("messages")
    val messages: String,
    @SerializedName("info")
    val info: Int
) {
    data class TranslateJSON(
        @SerializedName("translatedText")
        val translatedText: String,
        @SerializedName("detectedSourceLanguage")
        val detectedSourceLanguage: String,
    )
}

 */
