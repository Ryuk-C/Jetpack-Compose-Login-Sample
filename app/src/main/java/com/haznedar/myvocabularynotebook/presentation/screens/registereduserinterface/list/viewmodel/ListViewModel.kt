package com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.viewmodel

import android.content.Context
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haznedar.myvocabularynotebook.domain.use_case.get_language.LanguageUseCase
import com.haznedar.myvocabularynotebook.domain.use_case.get_word.WordsUseCase
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.state.LanguagesState
import com.haznedar.myvocabularynotebook.presentation.screens.registereduserinterface.list.state.WordsState
import com.haznedar.myvocabularynotebook.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(

    private val languagesUseCase: LanguageUseCase,
    private val wordsUseCase: WordsUseCase,
    @ApplicationContext val context: Context,

    ) : ViewModel() {

    private val _stateLanguage = mutableStateOf(LanguagesState())
    val stateLanguage: State<LanguagesState> = _stateLanguage

    private val _stateWords = mutableStateOf(WordsState())
    val stateWords: State<WordsState> = _stateWords

    var job: Job? = null

    fun getAllLanguages(Url: String, AppCode: String, UserID: String) {

        if (Url.trim().isEmpty() && AppCode.trim().isEmpty() && UserID.trim().isEmpty()) {

            _stateLanguage.value =
                LanguagesState(error = "Lütfen Değerleri Boş bırakmayınız", isLoading = false)

            return
        }

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            languagesUseCase(Url = Url, AppCode = AppCode, UserID = UserID).onEach { result ->

                when (result) {

                    is Resource.Loading -> {

                        _stateLanguage.value = LanguagesState(
                            isLoading = true,
                            internet = false
                        )

                    }

                    is Resource.Error -> {

                        _stateLanguage.value = LanguagesState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )

                    }

                    is Resource.Internet -> {

                        _stateLanguage.value = LanguagesState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )

                    }

                    is Resource.Success -> {

                        when (result.data?.success) {

                            0 -> {

                                _stateLanguage.value = stateLanguage.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    languageList = emptyList(),
                                    success = 0,
                                    defaultLanguageID = -1
                                )

                            }

                            1 -> {

                                _stateLanguage.value = stateLanguage.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    languageList = result.data.dillerJSON,
                                    success = 1,
                                    defaultLanguageID = result.data.useraktifdil
                                )

                            }

                            2 -> {

                                _stateLanguage.value = stateLanguage.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    languageList = emptyList(),
                                    success = 2,
                                    defaultLanguageID = result.data.useraktifdil
                                )

                            }
                        }

                    }
                }

            }.launchIn(viewModelScope)

        }

    }

    fun getAllWords(Url: String, AppCode: String, UserLAnguageID: String, UserID: String) {

        if (Url.trim().isEmpty() && AppCode.trim().isEmpty() && UserLAnguageID.trim()
                .isEmpty() && UserID.trim().isEmpty()
        ) {

            _stateWords.value =
                WordsState(error = "Lütfen Değerleri Boş bırakmayınız", isLoading = false)

            return
        }

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            wordsUseCase.invoke(Url, AppCode, UserLAnguageID, UserLAnguageID).onEach { result ->

                when (result) {

                    is Resource.Loading -> {

                        _stateWords.value = WordsState(
                            isLoading = true,
                            internet = false
                        )

                    }

                    is Resource.Internet -> {

                        _stateWords.value = WordsState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )

                    }

                    is Resource.Error -> {


                    }

                    is Resource.Success -> {

                        when (result.data?.success) {

                            0 -> {

                                _stateWords.value = stateWords.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    wordsList = emptyList(),
                                    success = 0,
                                )

                            }

                            1 -> {

                                Log.e("Kelimeler", result.data.kelimelerJSON.toString())
                                _stateWords.value = stateWords.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    wordsList = result.data.kelimelerJSON,
                                    success = 1,
                                )

                            }

                            2 -> {

                                _stateWords.value = stateWords.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    wordsList = emptyList(),
                                    success = 2,
                                )

                            }

                        }

                    }
                }

            }.launchIn(viewModelScope)

        }

    }

}