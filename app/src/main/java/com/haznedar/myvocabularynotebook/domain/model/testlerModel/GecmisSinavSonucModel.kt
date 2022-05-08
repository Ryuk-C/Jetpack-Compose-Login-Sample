package com.haznedar.kelimedefterim.model.testlerModel

import com.google.gson.annotations.SerializedName


data class GecmisSinavSonucModel(
    @SerializedName("KelimelerJSON")
    val kelimelerJSON: List<KelimelerJSON>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Int
) {
    data class KelimelerJSON(
        @SerializedName("toplam_dogru")
        val toplamDogru: String,
        @SerializedName("toplam_yanlis")
        val toplamYanlis: String
    )
}
/*
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GecmisSinavSonucModel(
    @Json(name = "KelimelerJSON")
    val kelimelerJSON: List<KelimelerJSON>,
    @Json(name = "message")
    val message: String,
    @Json(name = "success")
    val success: Int
) {
    @JsonClass(generateAdapter = true)
    data class KelimelerJSON(
        @Json(name = "toplam_dogru")
        val toplamDogru: String,
        @Json(name = "toplam_yanlis")
        val toplamYanlis: String
    )
}
 */