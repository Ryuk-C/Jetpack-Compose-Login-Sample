package com.haznedar.kelimedefterim.model.testlerModel

import com.google.gson.annotations.SerializedName


data class CoktanSecmeliTestModel(
    @SerializedName("message")
    val message: String,
    @SerializedName("SoruSiklarJSON")
    val soruSiklarJSON: List<SoruSiklarJSON>,
    @SerializedName("sorukelime")
    val sorukelime: String,
    @SerializedName("success")
    val success: Int
) {
    data class SoruSiklarJSON(
        @SerializedName("DY1")
        val dY1: String,
        @SerializedName("DY2")
        val dY2: String,
        @SerializedName("DY3")
        val dY3: String,
        @SerializedName("DY4")
        val dY4: String,
        @SerializedName("Pst_KullaniciDilID")
        val pstKullaniciDilID: String,
        @SerializedName("SecilenKelime")
        val secilenKelime: String,
        @SerializedName("SecilenKelimeID")
        val secilenKelimeID: String,
        @SerializedName("Sik1")
        val sik1: String,
        @SerializedName("Sik2")
        val sik2: String,
        @SerializedName("Sik3")
        val sik3: String,
        @SerializedName("Sik4")
        val sik4: String
    )
}