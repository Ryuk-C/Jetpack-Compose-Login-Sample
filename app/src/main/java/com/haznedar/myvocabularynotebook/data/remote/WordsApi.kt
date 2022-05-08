package com.haznedar.myvocabularynotebook.data.remote

import com.haznedar.kelimedefterim.model.KelimelerModel
import com.haznedar.kelimedefterim.model.LanguagesModel
import com.haznedar.myvocabularynotebook.domain.model.CrudModel
import com.haznedar.myvocabularynotebook.domain.model.LoginModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

interface WordsApi {

    @POST
    @FormUrlEncoded
    suspend fun logInUser(
        @Url url: String?,
        @Field("Pst_App_ID") AppCode: String,
        @Field("Pst_EMail") Email: String,
        @Field("Pst_Sifre") Sifre: String
    ): LoginModel

    @POST
    @FormUrlEncoded
    suspend fun signInUser(
        @Url url: String?,
        @Field("Pst_App_ID") AppCode: String,
        @Field("Pst_EMail") Email: String,
        @Field("Pst_Sifre") Sifre: String
    ): CrudModel

    @POST
    @FormUrlEncoded
    suspend fun listAllLanguages(
        @Url url: String?,
        @Field("Pst_App_ID") AppCode: String,
        @Field("Pst_User_ID") Pst_User_ID: String)
    : LanguagesModel

    @POST
    @FormUrlEncoded
    suspend fun listAllWords(
        @Url url: String?,
        @Field("Pst_App_ID") AppCode: String,
        @Field("Pst_Kullanici_Dil_ID") Pst_Dil_ID: String,
        @Field("Pst_User_ID") Pst_User_ID: String
    ): KelimelerModel

}