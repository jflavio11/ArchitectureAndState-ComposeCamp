package com.jflavio.archandstate.sideeffects

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.random.Random
import kotlin.random.nextInt

/**
 * RememberCoroutineScopeSample
 *
 * @since 11/17/2022
 */
@Composable
private fun ProfileScreen() {

    var score by remember { mutableStateOf(10) }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxWidth()) {

        Text(
            text = "Jose Flavio",
            style = MaterialTheme.typography.h5
        )

        Text(text = "Score: $score points")

        Button(onClick = {
            scope.launch {
                score = loadScore()
            }
        }) {
            Text(text = "Update profile")
        }

    }

}

private suspend fun loadScore() = withContext(Dispatchers.Default) {
    delay(2000)
    Random.nextInt(IntRange(0, 1000))
}

@Preview
@Composable
fun ProfilePreview() {
    ProfileScreen()
}