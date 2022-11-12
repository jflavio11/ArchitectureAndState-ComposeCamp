@file:OptIn(ExperimentalComposeUiApi::class)

package com.jflavio.archandstate.uistate.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jflavio.archandstate.R

/**
 * LoginScreen
 *
 * @since 11/10/2022
 */
@Composable
fun LoginScreen(
    viewModel: LoginViewModel
) {
    Column(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxSize()
    ) {
        val formUiState: LoginFormState = rememberLoginFormState()
        LoginHeader()
        LoginForm(
            formUiState = formUiState,
            onLoginButtonClicked = {
                viewModel.onLogin(formUiState.email, formUiState.password)
            }
        )
    }
}

@Composable
fun LoginHeader() {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "",
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterEnd)
        )
    }
}

@ExperimentalComposeUiApi
@Composable
private fun LoginForm(
    formUiState: LoginFormState = rememberLoginFormState(),
    onLoginButtonClicked: () -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        val keyboard = LocalSoftwareKeyboardController.current
        Text(
            text = "Welcome to Tuiter",
            style = MaterialTheme.typography.h5,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 12.dp, top = 12.dp)
        )
        OutlinedTextField(
            value = formUiState.email,
            onValueChange = {
                formUiState.email = it
            },
            isError = !formUiState.isValidEmail,
            label = {
                if (!formUiState.isValidEmail) {
                    Text(text = "Please, write a valid email.")
                } else {
                    Text(text = "Email address")
                }
            },
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )
        OutlinedTextField(
            value = formUiState.password,
            onValueChange = {
                formUiState.password = it
            },
            isError = !formUiState.isValidPassword,
            visualTransformation = PasswordVisualTransformation(),
            label = {
                if (!formUiState.isValidPassword) {
                    Text(text = "Please, write a valid password.")
                } else {
                    Text(text = "Password")
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .padding(bottom = 12.dp)
                .fillMaxWidth(),
            keyboardActions = KeyboardActions {
                keyboard?.hide()
            }
        )
        Spacer(modifier = Modifier.weight(1.0f))
        Button(
            onClick = { onLoginButtonClicked() },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.align(Alignment.End),
            enabled = formUiState.isFormValid
        ) {
            Text(text = "Log in")
        }
    }
}

@Preview
@Composable
fun LoginFormPreview() {
    LoginForm(onLoginButtonClicked = {})
}

@Preview
@Composable
fun LoginFormFilledPreview() {
    LoginForm(
        formUiState = LoginFormState(
            email = "email@email.com", password = "password123"
        ),
        onLoginButtonClicked = {}
    )
}

@Preview
@Composable
fun LoginFormErrorFilledPreview() {
    LoginForm(
        formUiState = LoginFormState(
            email = "email.com", password = "123"
        ),
        onLoginButtonClicked = {}
    )
}