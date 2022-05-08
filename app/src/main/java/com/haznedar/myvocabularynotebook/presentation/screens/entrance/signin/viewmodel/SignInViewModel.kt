package com.haznedar.myvocabularynotebook.presentation.screens.entrance.signin.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haznedar.myvocabularynotebook.R
import com.haznedar.myvocabularynotebook.domain.use_case.get_signin.SignInUseCase
import com.haznedar.myvocabularynotebook.presentation.screens.entrance.signin.state.SignInState
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
class SignInViewModel @Inject constructor(

    val signInUseCase: SignInUseCase

) : ViewModel() {

    private val _state = mutableStateOf(SignInState())
    val state: State<SignInState> = _state

    var job: Job? = null

    fun getRegisterUser(Url: String, AppCode: String, Username: String, Password: String) {

        if (Url.trim().isEmpty() && AppCode.trim().isEmpty() && Username.trim()
                .isEmpty() && Password.trim().isEmpty()
        ) {

            _state.value = SignInState(error = "Values can't be empty!", isLoading = false)

            return

        }

        job?.cancel()

        job = viewModelScope.launch(Dispatchers.IO) {

            signInUseCase.invoke(
                Url = Url,
                AppCode = AppCode,
                Email = Username,
                Password = Password
            ).onEach { result ->

                when (result) {

                    is Resource.Loading -> {
                        _state.value = SignInState(
                            isLoading = true,
                            internet = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = SignInState(
                            isLoading = false,
                            internet = false
                        )

                    }

                    is Resource.Internet -> {
                        delay(100)
                        _state.value = SignInState(
                            internet = true,
                            isLoading = false
                        )

                    }

                    is Resource.Success -> {
                        delay(100)

                        when (result.data?.success) {

                            0 -> {

                                _state.value = SignInState(
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
                                    success = 1
                                )

                            }

                            210 -> {

                                _state.value = SignInState(
                                    isLoading = false,
                                    success = 210,
                                    internet = false,
                                    error = "There is already an account registered with this e-mail address. You can login."
                                )
                            }
                        }
                    }
                }
            }.launchIn(viewModelScope)
        }
    }

    fun clearSignInViewModel() {

        state.value.internet = false
        state.value.isLoading = false
        state.value.success = -1
        state.value.registerList = emptyList()
        state.value.error = ""

    }
}
