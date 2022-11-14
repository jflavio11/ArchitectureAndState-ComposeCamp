package com.jflavio.archandstate.sideeffects

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * LaunchEffectSample
 *
 * @since 11/13/2022
 */
@Composable
private fun HiScreen(hiViewModel: HiViewModel = viewModel()) {

    LaunchedEffect(key1 = Unit, block = {
        hiViewModel.getNamesFromServer()
    })

    Text(text = "Hola, hola! ${hiViewModel.names}")

    // other views that causes recomposition
}

class HiViewModel : ViewModel() {
    var names by mutableStateOf(listOf<String>())
        private set

    fun getNamesFromServer() {
        viewModelScope.launch {
            delay(3000)
            names = listOf("Fiorella", "Jose", "Patricia")
        }
    }
}

@Preview
@Composable
fun HiScreenPreview() {
    HiScreen()
}
