package com.haznedar.kelimedefterim.model.testlerModel

import com.google.gson.annotations.SerializedName


data class YazmaAlistirmasiTestModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("SoruSiklarJSON")
    val soruSiklarJSON: List<SoruSiklarJSON>,
    @SerializedName("success")
    val success: Int
) {
    data class SoruSiklarJSON(
        @SerializedName("AnaKelime")
        val anaKelime: String,
        @SerializedName("KarsilikKelime")
        val karsilikKelime: String,
        @SerializedName("SecilenKelimeID")
        val secilenKelimeID: String
    )
}