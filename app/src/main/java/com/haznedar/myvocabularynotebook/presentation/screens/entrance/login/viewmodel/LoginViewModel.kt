package com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.viewmodel

import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haznedar.myvocabularynotebook.domain.use_case.get_login.LoginUseCase
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.login.state.LoginState
import com.haznedar.myvocabularynotebook.util.Resource
import com.haznedar.myvocabularynotebook.util.SpManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

    private val loginUseCase: LoginUseCase,
    @ApplicationContext val context: Context,

    ) : ViewModel() {

    private val _state = mutableStateOf(LoginState())
    val state: State<LoginState> = _state

    var job: Job? = null

    fun getUserLogin(url: String, appCode: String, email: String, password: String) {

        if (url.trim().isEmpty() && appCode.trim().isEmpty() && email.trim()
                .isEmpty() && password.trim().isEmpty()
        ) {

            _state.value =
                LoginState(error = "Values can't be empty!", isLoading = false)

            return
        }

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            loginUseCase(
                Url = url,
                AppCode = appCode,
                Email = email,
                Password = password
            ).onEach { result ->

                when (result) {

                    is Resource.Loading -> {
                        _state.value = LoginState(
                            isLoading = true,
                            internet = false
                        )

                    }

                    is Resource.Success -> {
                        when (result.data?.success) {

                            0 -> {

                                _state.value = LoginState(
                                    isLoading = false,
                                    success = 0,
                                    internet = false,
                                    error = result.data.message
                                )

                            }

                            1 -> {

                                for (i in result.data.loginJSON) {

                                    SpManager().setSharedPreference(
                                        context,
                                        SpManager.Sp.USERNAME,
                                        i.pstEMail
                                    )
                                    SpManager().setSharedPreference(
                                        context,
                                        SpManager.Sp.PASSWORD,
                                        i.pstSifre
                                    )
                                    SpManager().setSharedPreference(
                                        context,
                                        SpManager.Sp.USERID,
                                        i.pstKullaniciID
                                    )


                                }

                                _state.value = state.value.copy(
                                    isLoading = false,
                                    internet = false,
                                    loginList = result.data.loginJSON,
                                    success = 1
                                )


                            }

                            202 -> {

                                _state.value = LoginState(
                                    isLoading = false,
                                    success = 202,
                                    internet = false,
                                    error = "Unregistered Email Address"
                                )


                            }

                            203 -> {

                                _state.value = LoginState(
                                    isLoading = false,
                                    success = 203,
                                    internet = false,
                                    error = "Wrong Password"
                                )
                            }
                        }
                    }

                    is Resource.Internet -> {
                        delay(200)
                        _state.value = LoginState(
                            internet = true,
                            isLoading = false
                        )

                    }

                    is Resource.Error -> {
                        delay(200)
                        _state.value = LoginState(
                            error = result.message ?: "An unexpected error occurred",
                            isLoading = false
                        )

                    }
                }

            }.launchIn(viewModelScope)

        }

    }

    fun clearViewModel() {

        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.loginList = emptyList()
        state.value.error = ""

    }

}

