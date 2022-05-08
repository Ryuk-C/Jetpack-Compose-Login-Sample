package com.haznedar.kelimedefterim.model

import com.google.gson.annotations.SerializedName

data class KelimelerModel(
    @SerializedName("KelimelerJSON")
    val kelimelerJSON: List<KelimelerJSON>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Int
) {
    data class KelimelerJSON(
        @SerializedName("AnaKelime")
        val anaKelime: String,
        @SerializedName("KarsilikKelime")
        val karsilikKelime: String,
        @SerializedName("KelimeID")
        val kelimeID: String,
        @SerializedName("OrnekCumle")
        val ornekCumle: String,
        @SerializedName("favori")
        val favori: String,
    )
}



/*
@JsonClass(generateAdapter = true)
data class KelimelerModel(
    @Json(name = "KelimelerJSON")
    val kelimelerJSON: List<KelimelerJSON>,
    @Json(name = "message")
    val message: String,
    @Json(name = "success")
    val success: Int
) {
    @JsonClass(generateAdapter = true)
    data class KelimelerJSON(
        @Json(name = "AnaKelime")
        val anaKelime: String,
        @Json(name = "favori")
        val favori: String,
        @Json(name = "KarsilikKelime")
        val karsilikKelime: String,
        @Json(name = "KelimeID")
        val kelimeID: String,
        @Json(name = "OrnekCumle")
        val ornekCumle: String
    )
}
 */