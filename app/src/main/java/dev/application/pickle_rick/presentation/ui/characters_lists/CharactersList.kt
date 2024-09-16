package dev.application.pickle_rick.presentation.ui.characters_lists

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState.Loading
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.presentation.ui.character_item_blocks.CharacterItemBlock
import dev.application.pickle_rick.presentation.ui.common.ComposeLoader
import kotlinx.coroutines.flow.flowOf

@Composable
fun CharactersList(
    lazyPagingItems: LazyPagingItems<CharacterModel>,
    favoriteIdList: List<String>,
    onLikeClick: (String) -> Unit,
    onItemBlockClick: (String) -> Unit,
) {
    val listState = rememberLazyListState()
    var wasItemBlockClicked = false
    LazyColumn(state = listState) {
        items(
            count = lazyPagingItems.itemCount,
            key = { index -> index }
        ) { index ->
            lazyPagingItems[index]?.let { characterModel ->
                val isFavorite = favoriteIdList.contains(characterModel.id)
                val character = characterModel.copy(favorite = isFavorite)
                CharacterItemBlock(
                    characterModel = character,
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

        if (lazyPagingItems.loadState.append == Loading) {
            item {
                ComposeLoader(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharactersListPreview() {
    CharactersList(
        lazyPagingItems = flowOf(
            PagingData.from(
                listOf(
                    CharacterModel(),
                    CharacterModel(),
                    CharacterModel()
                )
            )
        ).collectAsLazyPagingItems(),
        favoriteIdList = emptyList(),
        onLikeClick = {},
        onItemBlockClick = {},
    )
}
