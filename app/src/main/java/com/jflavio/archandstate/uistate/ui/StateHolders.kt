package com.jflavio.archandstate.uistate.ui

import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

/**
 * LoginUiState
 *
 * @since 11/10/2022
 */

// region Screen State
data class LoginUiState(
    val errorInfo: LoginError? = null,
    val loggedIn: Boolean = false
)

data class LoginError(
    val code: Int,
    val message: String
)
// endregion


// region ui element state
@Stable
class LoginFormState(
    email: String,
    password: String
) {
    var email by mutableStateOf(email)
    var password by mutableStateOf(password)
    val isValidEmail by derivedStateOf { if (this.email.isNotEmpty()) this.email.isValidEmail() else true }
    val isValidPassword by derivedStateOf { if (this.password.isNotEmpty()) this.password.length > 3 else true }

    val isFormValid by derivedStateOf {
        this.email.isNotEmpty() && this.password.isNotEmpty() && isValidEmail && isValidPassword
    }

    companion object {
        val Saver = listSaver<LoginFormState, Any>(
            save = { listOf(it.email, it.password) },
            restore = {
                LoginFormState(it[0] as String, it[1] as String)
            }
        )
    }
}

@Composable
fun rememberLoginFormState(
    email: String = "",
    password: String = ""
) = rememberSaveable(
    saver = LoginFormState.Saver
) {
    LoginFormState(email, password)
}
// endregion

// extensions
fun CharSequence?.isValidEmail() = Patterns.EMAIL_ADDRESS.matcher(this.toString()).matches()