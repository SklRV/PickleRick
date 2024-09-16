package dev.application.pickle_rick.presentation.screens.character_info

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import dev.application.pickle_rick.presentation.ui.character_info_blocks.CharacterInfoBlock
import dev.application.pickle_rick.presentation.ui.common.ComposeLoader
import dev.application.pickle_rick.presentation.ui.common.InternetProblemsBlock

@Composable
fun CharacterInfoScreen(
    characterId: String
) {
    val viewModel = hiltViewModel<CharacterInfoViewModel>()
    val state by viewModel.state.collectAsState()
    val characterInfo = state.characterInfo

    when {
        state.isError ->
            InternetProblemsBlock(onRefreshClick = { viewModel.loadCharacter(characterId) })

        characterInfo.id.isEmpty() -> {
            ComposeLoader(modifier = Modifier.fillMaxSize())
            viewModel.loadCharacter(characterId)
        }

        state.isLoading ->
            ComposeLoader(modifier = Modifier.fillMaxSize())

        else -> CharacterInfoBlock(
            characterInfo = characterInfo,
            onLikeClick = { viewModel.onLikeClicked() })
    }
}
