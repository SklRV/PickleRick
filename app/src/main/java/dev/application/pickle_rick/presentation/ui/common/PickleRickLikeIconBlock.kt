package dev.application.pickle_rick.presentation.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R

@Composable
fun PickleRickLikeIconBlock(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onLikeClick: () -> Unit,
) {
    Image(
        modifier = modifier
            .size(52.dp)
            .clip(CircleShape)
            .background(colorResource(R.color.gray_50))
            .border(
                width = 2.dp,
                color =
                if (isFavorite) colorResource(R.color.turquoise)
                else colorResource(R.color.gray_05),
                shape = CircleShape
            )
            .clickable { onLikeClick() },
        painter = painterResource(
            id =
            if (isFavorite) R.drawable.pickle_rick_green
            else R.drawable.pickle_rick_gray
        ),
        contentDescription = stringResource(R.string.favorite_button)
    )
}

@Preview(showBackground = true)
@Composable
fun PickleRickLikeIconBlockPreview() {
    PickleRickLikeIconBlock(
        isFavorite = true,
        onLikeClick = {}
    )
}
