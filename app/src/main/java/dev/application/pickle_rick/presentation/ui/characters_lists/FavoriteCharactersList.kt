package dev.application.pickle_rick.presentation.ui.characters_lists

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.application.pickle_rick.R
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.presentation.ui.character_item_blocks.CharacterItemBlock
import dev.application.pickle_rick.presentation.ui.character_item_blocks.CharacterItemNoFavoriteBlock

@Composable
fun FavoriteCharactersList(
    favoriteCharactersItems: List<CharacterModel>,
    onLikeClick: (String) -> Unit,
    onItemBlockClick: (String) -> Unit
) {
    var wasItemBlockClicked = false
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(
            items = favoriteCharactersItems,
            key = { item -> item.id }
        ) { characterModel ->
            CharacterItemBlock(
                modifier = Modifier.animateItem(fadeInSpec = null, fadeOutSpec = null),
                characterModel = characterModel,
                onLikeClick = { onLikeClick(characterModel.id) },
                onItemBlockClick = {
                    if (!wasItemBlockClicked) {
                        wasItemBlockClicked = true
                        onItemBlockClick(characterModel.id)
                    }
                }
            )
        }
    }

    if (favoriteCharactersItems.isEmpty())
        CharacterItemNoFavoriteBlock(stringResource = R.string.have_not_filtered_favorite_characters)

}

@Preview(showBackground = true)
@Composable
fun FavoriteCharactersListPreview() {
    FavoriteCharactersList(
        favoriteCharactersItems = listOf(
            CharacterModel(),
            CharacterModel(),
            CharacterModel()
        ),
        onLikeClick = {},
        onItemBlockClick = {},
    )
}
