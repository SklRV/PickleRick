package dev.application.pickle_rick.presentation.screens.favorite_characters

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.application.pickle_rick.R
import dev.application.pickle_rick.common.client_result.DataSourceException.Server
import dev.application.pickle_rick.common.client_result.DataSourceException.Unexpected
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.presentation.ui.character_item_blocks.CharacterItemNoFavoriteBlock
import dev.application.pickle_rick.presentation.ui.characters_lists.FavoriteCharactersList
import dev.application.pickle_rick.presentation.ui.common.ComposeLoader
import dev.application.pickle_rick.presentation.ui.common.InternetProblemsBlock
import dev.application.pickle_rick.domain.model.Gender
import dev.application.pickle_rick.domain.model.Status

@Composable
fun FavoriteCharactersScreen(
    filters: CharactersFilters,
    onItemBlockClick: (String) -> Unit
) {
    val viewModel = hiltViewModel<FavoriteCharactersViewModel>()
    val state by viewModel.state.collectAsState()
    when {
        state.isError is Server ->
            InternetProblemsBlock(onRefreshClick = { viewModel.loadCharacters() })

        state.isError is Unexpected ->
            CharacterItemNoFavoriteBlock(stringResource = R.string.have_not_favorite_characters)

        state.charactersList.isEmpty() -> {
            ComposeLoader(modifier = Modifier.fillMaxSize())
            viewModel.loadCharacters()
        }

        state.isLoading ->
            ComposeLoader(modifier = Modifier.fillMaxSize())

        else -> {
            viewModel.updateFavoritesChanges()
            val favoriteCharactersItems = state.charactersList
                .filter { if (filters.gender == Gender.ALL) true else it.gender == filters.gender.value }
                .filter { if (filters.status == Status.ALL) true else it.status == filters.status.value }
            FavoriteCharactersList(
                favoriteCharactersItems = favoriteCharactersItems,
                onLikeClick = { id -> viewModel.onLikeClicked(id) },
                onItemBlockClick = onItemBlockClick
            )
        }
    }
}
