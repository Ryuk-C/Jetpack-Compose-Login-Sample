package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings.state

import com.haznedar.kelimedefterim.model.KelimelerModel

data class SettingsState(
    var isLoading: Boolean = false,
    var success: Int = -1,
    var wordsList: List<KelimelerModel.KelimelerJSON> = emptyList(),
    var error: String = "",
    var internet: Boolean = false,
    var closeApp : Boolean = false
)