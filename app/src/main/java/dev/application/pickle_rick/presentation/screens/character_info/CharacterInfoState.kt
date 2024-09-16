package dev.application.pickle_rick.presentation.screens.character_info

import dev.application.pickle_rick.domain.model.CharacterInfoModel

data class CharacterInfoState(
    val characterInfo: CharacterInfoModel = CharacterInfoModel(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)
