package com.haznedar.myvocabularynotebook.presentation.screens.entrance.signin.state

import com.haznedar.myvocabularynotebook.domain.model.CrudModel

data class SignInState(
    var isLoading: Boolean = false,
    var success: Int = -1,
    var registerList : List<CrudModel> = emptyList(),
    var error : String = "",
    var internet : Boolean = false,
)