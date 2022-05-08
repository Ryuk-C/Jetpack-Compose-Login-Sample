package com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.state

import com.haznedar.myvocabularynotebook.domain.model.LoginModel

data class LoginState(
    var isLoading : Boolean = false,
    var success : Int = -1,
    var loginList : List<LoginModel.LoginJSON> = emptyList(),
    var error : String = "",
    var internet : Boolean = false
)