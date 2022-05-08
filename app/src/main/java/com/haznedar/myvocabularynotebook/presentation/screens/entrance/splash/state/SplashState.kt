package com.haznedar.myvocabularynotebook.presentation.screens.entrance.splash.state

import com.haznedar.myvocabularynotebook.domain.model.LoginModel

data class SplashState (
    val isLoading : Boolean = false,
    val loginList : List<LoginModel.LoginJSON> = emptyList(),
    val success : Int = -1,
    val error : String = "",
    val internet :  Boolean = false
)