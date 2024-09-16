package dev.application.pickle_rick.presentation.ui.character_item_blocks

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R

@Composable
fun CharacterItemNoFavoriteBlock(
    modifier: Modifier = Modifier,
    stringResource: Int
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(stringResource),
            color = colorResource(R.color.gray_30),
            fontSize = TextUnit(16f, TextUnitType.Sp)
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun CharacterItemNoFavoriteBlockPreview() {
    CharacterItemNoFavoriteBlock(stringResource = R.string.have_not_favorite_characters)
}
