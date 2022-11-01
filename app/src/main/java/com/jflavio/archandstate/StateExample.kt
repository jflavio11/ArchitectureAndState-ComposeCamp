package com.jflavio.archandstate

import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EmailField() {
    var email by remember { mutableStateOf("") }
    var isError by remember { mutableStateOf(false) }
    OutlinedTextField(value = email, onValueChange = { newValue ->
        email = newValue
        isError = !email.contains("@") // ps: you must not validate this here!
    }, colors = TextFieldDefaults.outlinedTextFieldColors(
        focusedBorderColor = Color.DarkGray,
        unfocusedBorderColor = Color.DarkGray,
        textColor = Color.Black,
        backgroundColor = Color.White,
        errorLabelColor = Color.Red
    ), isError = isError, modifier = Modifier.padding(12.dp), label = {
        Text(
            text = if (isError) {
                "Por favor, escribe un email válido"
            } else {
                "email@example.com"
            }
        )
    })
}

@Preview
@Composable
fun EmailFieldPreview() {
    EmailField()
}

// Best practice, just pass data to be shown
@Composable
private fun MyLoader(progress: Float) {
    LinearProgressIndicator(
        progress = progress, color = Color.Red, backgroundColor = Color.Black, modifier = Modifier.padding(5.dp)
    )
}

// Bad practice
@Composable
private fun MyLoader2(uploadState: UploadPictureState) {
    LinearProgressIndicator(
        progress = uploadState.progress, color = Color.Red, backgroundColor = Color.Black, modifier = Modifier.padding(5.dp)
    )
}

@Preview(showBackground = true, name = "10%")
@Composable
private fun DefaultPreview1() {
    MyLoader(progress = 0.10f)
}

@Preview(showBackground = true, name = "50%")
@Composable
private fun DefaultPreview2() {
    MyLoader(progress = 0.50f)
}

@Preview(showBackground = true, name = "75%")
@Composable
private fun DefaultPreview3() {
    MyLoader(progress = 0.75f)
}

@Preview(showBackground = true, name = "100%")
@Composable
private fun DefaultPreview4() {
    MyLoader(progress = 1.0f)
}

@Stable
private data class UploadPictureState(
    val picturePath: String, val pictureServerUrl: String? = null, val progress: Float
)