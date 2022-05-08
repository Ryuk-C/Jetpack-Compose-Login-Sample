package com.haznedar.kelimedefterim.model

import com.google.gson.annotations.SerializedName

data class LanguagesModel(
    @SerializedName("DillerJSON")
    val dillerJSON: List<DillerJSON>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Int,
    @SerializedName("useraktifdil")
    val useraktifdil: Int
) {
    data class DillerJSON(
        @SerializedName("DilAd")
        val dilAd: String,
        @SerializedName("KullaniciDilID")
        val kullaniciDilID: String,
        @SerializedName("ToplamKelimeSayisi")
        val toplamKelimeSayisi: String,
        @SerializedName("Icon")
        val icon: String
    )
}


/*
@JsonClass(generateAdapter = true)
data class DillerModel(
    @Json(name = "DillerJSON")
    val dillerJSON: List<DillerJSON>,
    @Json(name = "message")
    val message: String,
    @Json(name = "success")
    val success: Int,
    @Json(name = "useraktifdil")
    val useraktifdil: Int
) {
    @JsonClass(generateAdapter = true)
    data class DillerJSON(
        @Json(name = "DilAd")
        val dilAd: String,
        @Json(name = "KullaniciDilID")
        val kullaniciDilID: String,
        @Json(name = "ToplamKelimeSayisi")
        val toplamKelimeSayisi: String,
        @Json(name = "Icon")
        val icon: String
    )
}
 */