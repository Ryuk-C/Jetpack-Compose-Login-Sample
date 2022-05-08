package com.haznedar.myvocabularynotebook.data.repository

import com.haznedar.kelimedefterim.model.KelimelerModel
import com.haznedar.kelimedefterim.model.LanguagesModel
import com.haznedar.myvocabularynotebook.domain.model.CrudModel
import com.haznedar.myvocabularynotebook.domain.model.LoginModel

interface WordsRepositoryInterface {

    suspend fun userLogin(url:String, appcode:String, email:String, password:String) : LoginModel

    suspend fun userRegister(Url:String, appcode:String, email:String, password:String) : CrudModel

    suspend fun listAllLanguage(Url: String, AppCode:String, userID:String) : LanguagesModel

    suspend fun listAllWords(Url: String, AppCode: String, UserLanguageID : String, UserID:String) : KelimelerModel
}