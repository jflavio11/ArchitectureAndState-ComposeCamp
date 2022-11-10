package com.jflavio.archandstate.uistate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.jflavio.archandstate.uistate.ui.LoginScreen
import com.jflavio.archandstate.uistate.ui.LoginViewModel
import com.jflavio.archandstate.uistate.ui.theme.ArchAndStateTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchAndStateTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val viewModel: LoginViewModel by viewModels()
                    LoginScreen(viewModel)
                }
            }
        }
    }
}
