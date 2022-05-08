package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.state

import com.haznedar.kelimedefterim.model.KelimelerModel

data class WordsState(
    var isLoading: Boolean = false,
    var success: Int = -1,
    var wordsList: List<KelimelerModel.KelimelerJSON> = emptyList(),
    var error: String = "",
    var internet: Boolean = false,
)