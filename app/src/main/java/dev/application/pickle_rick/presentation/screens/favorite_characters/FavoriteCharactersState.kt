package dev.application.pickle_rick.presentation.screens.favorite_characters

import dev.application.pickle_rick.common.client_result.DataSourceException
import dev.application.pickle_rick.domain.model.CharacterModel

data class FavoriteCharactersState(
    val charactersList: List<CharacterModel> = emptyList(),
    val isLoading: Boolean = false,
    val isError: DataSourceException? = null
)
