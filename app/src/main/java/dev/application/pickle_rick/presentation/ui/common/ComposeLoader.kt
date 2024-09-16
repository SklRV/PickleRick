package dev.application.pickle_rick.presentation.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R

@Composable
fun ComposeLoader(
    modifier: Modifier
) {
    Box(modifier = modifier) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(40.dp)
                .align(Alignment.Center),
            color = colorResource(R.color.black),
            strokeWidth = 4.dp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeLoaderPreview() {
    ComposeLoader(modifier = Modifier.fillMaxSize())
}
