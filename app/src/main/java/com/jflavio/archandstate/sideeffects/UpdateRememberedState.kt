package com.jflavio.archandstate.sideeffects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

/**
 * UpdateRememberedState
 *
 * @since 11/13/2022
 */
@Composable
fun UserAgeView() {
    var yearBorn by remember { mutableStateOf(2000) }
    AgeView(
        yearBorn = yearBorn,
        onYearUpdated = { yearBorn = it }
    )
}

@Composable
private fun AgeView(
    yearBorn: Int,
    onYearUpdated: (Int) -> Unit
) {
    val updatedYearOld by rememberUpdatedState(newValue = yearBorn)
    var adultText by remember {
        mutableStateOf("Cargando...")
    }
    LaunchedEffect(key1 = Unit, block = {
        delay(3000) // long running operation
        adultText = if (2022 - updatedYearOld > 17) {
            "Eres mayor de edad"
        } else {
            "Eres menor de edad"
        }
    })

    Column {
        Text(text = adultText)
        TextField(
            value = yearBorn.toString(),
            onValueChange = {
                onYearUpdated(it.toInt())
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )
    }


}

@Preview
@Composable
fun AgeViewPreview() {
    UserAgeView()
}