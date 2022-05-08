package com.haznedar.kelimedefterim.model

import com.google.gson.annotations.SerializedName


data class FavorilerModel(
    @SerializedName("KelimelerJSON")
    val kelimelerJSON: List<KelimelerJSON>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Int
) {
    data class KelimelerJSON(
        @SerializedName("favori")
        val favori: String,
        @SerializedName("KelimeID")
        val kelimeID: String
    )
}

/*
@JsonClass(generateAdapter = true)
data class FavorilerModel(
    @Json(name = "KelimelerJSON")
    val kelimelerJSON: List<KelimelerJSON>,
    @Json(name = "message")
    val message: String,
    @Json(name = "success")
    val success: Int
) {
    @JsonClass(generateAdapter = true)
    data class KelimelerJSON(
        @Json(name = "favori")
        val favori: String,
        @Json(name = "KelimeID")
        val kelimeID: String
    )
}
 */