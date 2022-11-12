package com.jflavio.archandstate.uistate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jflavio.archandstate.uistate.ui.HomeScreen
import com.jflavio.archandstate.uistate.ui.LoginScreen
import com.jflavio.archandstate.uistate.ui.LoginViewModel
import com.jflavio.archandstate.uistate.ui.theme.ArchAndStateTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArchAndStateTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    val loginViewModel: LoginViewModel by viewModels()
                    val initialRoute = if(loginViewModel.loginUiState.loggedIn) "home" else "login"
                    NavHost(navController = navController, startDestination = initialRoute) {
                        composable("login") {
                            LoginScreen(viewModel = loginViewModel)
                        }
                        composable("home") {
                            HomeScreen()
                        }
                    }
                }
            }
        }
    }
}
