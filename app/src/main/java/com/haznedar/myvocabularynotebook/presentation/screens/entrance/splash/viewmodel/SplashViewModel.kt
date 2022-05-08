package com.haznedar.myvocabularynotebook.presentation.screens.entrance.splash.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haznedar.myvocabularynotebook.domain.use_case.get_login.LoginUseCase
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.splash.state.SplashState
import com.haznedar.myvocabularynotebook.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(

    private val LoginUseCase: LoginUseCase

) : ViewModel() {

    private val _state = mutableStateOf(SplashState())
    val state: State<SplashState> = _state

    private var job: Job? = null

    fun getUserLogin(url: String, appCode: String, email: String, password: String) {

        if (url.isEmpty() && appCode.isEmpty() && email.isEmpty() && password.isEmpty()) {

            _state.value = SplashState(
                success = 4,
                error = "Values can't be empty!",
                isLoading = false
            )

            return
        }

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            LoginUseCase(
                Url = url,
                AppCode = appCode,
                Email = email,
                Password = password
            ).onEach { result ->

                when (result) {

                    is Resource.Loading -> {
                        _state.value = SplashState(isLoading = true)

                    }

                    is Resource.Success -> {
                        delay(2250)

                        when (result.data?.success) {

                            0 -> {

                                _state.value = SplashState(
                                    isLoading = false,
                                    success = 0,
                                    internet = false,
                                    error = result.data.message
                                )

                            }

                            1 -> {

                                _state.value = state.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    loginList = result.data.loginJSON,
                                    success = 1
                                )

                            }

                            202 -> {

                                _state.value = SplashState(
                                    isLoading = false,
                                    success = 202,
                                    internet = false,
                                    error = "Unferistered Mail Adress!"
                                )

                            }

                            203 -> {

                                _state.value = SplashState(
                                    isLoading = false,
                                    success = 203,
                                    internet = false,
                                    error = "Wrong Password!"
                                )
                            }
                        }
                    }

                    is Resource.Internet -> {
                        delay(2000)

                        _state.value = SplashState(
                            internet = true,
                            isLoading = false
                        )

                    }

                    is Resource.Error -> {
                        delay(2000)

                        _state.value = SplashState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )

                    }
                }

            }.launchIn(viewModelScope)

        }

    }
}
