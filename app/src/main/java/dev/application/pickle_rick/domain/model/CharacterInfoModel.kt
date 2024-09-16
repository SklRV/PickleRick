package dev.application.pickle_rick.domain.model

data class CharacterInfoModel(
    val id: String = "",
    val name: String = "",
    val species: String = "",
    val status: String = "",
    val type: String = "",
    val gender: String = "",
    val originLocation: String = "",
    val lastLocation: String = "",
    val episodes: List<CharacterEpisodesModel> = emptyList(),
    val image: String = "",
    val favorite: Boolean = false
)
