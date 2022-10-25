package com.jflavio.archandstate

import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Best practice, just pass data to be shown
@Composable
private fun MyLoader(progress: Float) {
    LinearProgressIndicator(
        progress = progress,
        color = Color.Red,
        backgroundColor = Color.Black,
        modifier = Modifier.padding(5.dp)
    )
}

// Bad practice
@Composable
private fun MyLoader2(uploadState: UploadPictureState) {
    LinearProgressIndicator(
        progress = uploadState.progress,
        color = Color.Red,
        backgroundColor = Color.Black,
        modifier = Modifier.padding(5.dp)
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

@Preview(showBackground = true, name = "10%")
@Composable
private fun DefaultPreview4() {
    MyLoader(progress = 0.100f)
}

@Stable
private data class UploadPictureState(
    val picturePath: String,
    val pictureServerUrl: String? = null,
    val progress: Float
)