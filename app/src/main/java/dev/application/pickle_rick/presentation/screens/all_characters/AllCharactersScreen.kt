package dev.application.pickle_rick.presentation.screens.all_characters

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.presentation.ui.characters_lists.CharactersList
import dev.application.pickle_rick.presentation.ui.common.ComposeLoader
import dev.application.pickle_rick.presentation.ui.common.InternetProblemsBlock

@Composable
fun AllCharactersScreen(
    filters: CharactersFilters,
    onItemBlockClick: (String) -> Unit,
) {
    val viewModel = hiltViewModel<AllCharactersViewModel>()

    val lazyPagingItems = viewModel.allCharactersState.collectAsLazyPagingItems()
    val state by viewModel.state.collectAsState()
    viewModel.checkFilters(filters)
    viewModel.updateFavoritesChanges()

    when {
        lazyPagingItems.loadState.refresh is LoadState.Loading ->
            ComposeLoader(modifier = Modifier.fillMaxSize())

        lazyPagingItems.loadState.refresh is LoadState.Error ->
            InternetProblemsBlock(onRefreshClick = { viewModel.getAllCharacters(filters) })

        lazyPagingItems.loadState.append is LoadState.Error ->
            InternetProblemsBlock(onRefreshClick = { viewModel.getAllCharacters(filters) })

        else ->
            CharactersList(
                lazyPagingItems = lazyPagingItems,
                favoriteIdList = state.favoriteIdsList,
                onLikeClick = { id -> viewModel.onLikeClicked(id) },
                onItemBlockClick = onItemBlockClick,
            )
    }
}
