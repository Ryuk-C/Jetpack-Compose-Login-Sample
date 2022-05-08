package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.state

import com.haznedar.kelimedefterim.model.LanguagesModel

data class LanguagesState(
    var isLoading: Boolean = false,
    var success: Int = -1,
    var languageList: List<LanguagesModel.DillerJSON> = emptyList(),
    var error: String = "",
    var internet: Boolean = false,
    var defaultLanguageID : Int = -1
)