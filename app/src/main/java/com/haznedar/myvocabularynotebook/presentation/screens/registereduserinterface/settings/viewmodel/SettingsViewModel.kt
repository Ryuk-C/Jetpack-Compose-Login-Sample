package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.state.LanguagesState
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.settings.state.SettingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor() : ViewModel() {

    private val _stateSettings = mutableStateOf(SettingsState())
    val stateSettings: State<SettingsState> = _stateSettings

    fun changeState() {

        Log.e("View Model Tetik", "Çalıştı")

        viewModelScope.launch {

            _stateSettings.value = SettingsState(
                closeApp = true
            )

        }



    }


}