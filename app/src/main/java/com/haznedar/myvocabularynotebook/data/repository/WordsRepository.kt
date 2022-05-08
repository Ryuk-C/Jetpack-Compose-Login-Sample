package com.haznedar.myvocabularynotebook.data.repository

import com.haznedar.kelimedefterim.model.KelimelerModel
import com.haznedar.kelimedefterim.model.LanguagesModel
import com.haznedar.myvocabularynotebook.domain.model.CrudModel
import com.haznedar.myvocabularynotebook.domain.model.LoginModel
import com.haznedar.myvocabularynotebook.data.remote.WordsApi
import javax.inject.Inject

class WordsRepository @Inject constructor(

    private val api : WordsApi

) : WordsRepositoryInterface {

    override suspend fun userLogin(url: String, appcode: String, email: String, password: String): LoginModel {
        return api.logInUser(url, appcode, email, password)
    }

    override suspend fun userRegister(Url: String, appcode: String, email: String, password: String): CrudModel {
       return  api.signInUser(Url, appcode, email, password)
    }

    override suspend fun listAllLanguage(Url: String, AppCode:String, userID: String): LanguagesModel {
        return api.listAllLanguages(Url,AppCode, userID)
    }

    override suspend fun listAllWords(
        Url: String,
        AppCode: String,
        UserLanguageID: String,
        UserID: String
    ): KelimelerModel {

        return api.listAllWords(Url, AppCode, UserLanguageID, UserID)

    }


}