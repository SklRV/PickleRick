package dev.application.pickle_rick.presentation.ui.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import dev.application.pickle_rick.R

@Composable
fun CharacterImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    status: String,
    characterImageSize: CharacterImageSize = CharacterImageSize.SMALL
) {
    with(characterImageSize) {
        AsyncImage(
            modifier = modifier
                .size(size)
                .clip(CircleShape)
                .border(
                    width = contourColourWidth,
                    color = colorResource(id = setStatusColour(status)),
                    shape = CircleShape
                )
                .border(
                    width = contourWhiteWidth,
                    color = colorResource(R.color.white),
                    shape = CircleShape
                ),
            model = imageUrl,
            contentDescription = stringResource(R.string.avatar),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterImagePreview() {
    CharacterImage(
        imageUrl = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
        status = "Dead"
    )
}
