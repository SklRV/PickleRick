package dev.application.pickle_rick.presentation.ui.character_item_blocks

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import dev.application.pickle_rick.R

@Composable
fun CharacterItemNameAndSpeciesBlock(
    modifier: Modifier = Modifier,
    name: String,
    species: String
) {
    Column(modifier = modifier) {
        Text(
            text = name,
            color = colorResource(R.color.black),
            fontSize = TextUnit(18f, TextUnitType.Sp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
        Text(
            text = species,
            color = colorResource(R.color.gray_30),
            fontSize = TextUnit(14f, TextUnitType.Sp),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterItemNameAndSpeciesBlockPreview() {
    CharacterItemNameAndSpeciesBlock(
        name = "Name",
        species = "Human"
    )
}
