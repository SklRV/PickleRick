package dev.application.pickle_rick.domain.model

data class CharacterModel(
    val id: String = "",
    val name: String = "",
    val species: String = "",
    val status: String = "",
    val gender: String = "",
    val image: String = "",
    var favorite: Boolean = false
)
