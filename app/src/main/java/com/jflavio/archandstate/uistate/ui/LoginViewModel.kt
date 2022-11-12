package com.jflavio.archandstate.uistate.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jflavio.archandstate.uistate.domain.LoginUseCase
import kotlinx.coroutines.launch

/**
 * LoginViewModel
 *
 * @since 11/10/2022
 */
class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    var loginUiState by mutableStateOf(LoginUiState())
        private set

    fun onLogin(username: String, password: String) {
        viewModelScope.launch {
            loginUseCase.execute(username, password)
            loginUiState = loginUiState.copy(loggedIn = true, errorInfo = null)
        }
    }

}