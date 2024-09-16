package dev.application.pickle_rick.domain.model

data class CharactersFilters(
    val gender: Gender = Gender.ALL,
    val status: Status = Status.ALL
)
