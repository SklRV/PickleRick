package dev.application.pickle_rick.presentation.ui.character_item_blocks

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.application.pickle_rick.R
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.presentation.ui.common.CharacterImage
import dev.application.pickle_rick.presentation.ui.common.PickleRickLikeIconBlock
import dev.application.pickle_rick.presentation.ui.common.SpacerWidth

@Composable
fun CharacterItemBlock(
    modifier: Modifier = Modifier,
    characterModel: CharacterModel,
    onItemBlockClick: () -> Unit,
    onLikeClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .height(92.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(colorResource(R.color.gray_05))
            .border(
                width = 2.dp,
                color = colorResource(R.color.black),
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onItemBlockClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CharacterImage(
            imageUrl = characterModel.image,
            status = characterModel.status
        )
        SpacerWidth(16)
        CharacterItemNameAndSpeciesBlock(
            modifier = Modifier.weight(1f),
            name = characterModel.name,
            species = characterModel.species
        )
        PickleRickLikeIconBlock(
            isFavorite = characterModel.favorite,
            onLikeClick = onLikeClick
        )
    }
}

@Preview(showBackground = true, widthDp = 400)
@Composable
fun CharacterItemBlockPreview() {
    CharacterItemBlock(
        characterModel = CharacterModel(
            image = "https://rickandmortyapi.com/api/character/avatar/361.jpeg",
            name = "Имя персонажа Имя персонажа",
            species = "Вид персонажа"
        ),
        onItemBlockClick = {},
        onLikeClick = {}
    )
}
