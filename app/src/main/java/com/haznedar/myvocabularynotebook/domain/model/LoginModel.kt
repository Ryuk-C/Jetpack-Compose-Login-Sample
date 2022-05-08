package com.haznedar.myvocabularynotebook.domain.model

import com.google.gson.annotations.SerializedName

data class LoginModel(
    @SerializedName("LoginJSON")
    val loginJSON: List<LoginJSON>,
    @SerializedName("message")
    val message: String,
    @SerializedName("success")
    val success: Int
) {
    data class LoginJSON(
        @SerializedName("Pst_EMail")
        val pstEMail: String,
        @SerializedName("Pst_KullaniciID")
        val pstKullaniciID: String,
        @SerializedName("Pst_Sifre")
        val pstSifre: String
    )
}