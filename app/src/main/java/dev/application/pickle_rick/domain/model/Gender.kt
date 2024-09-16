package dev.application.pickle_rick.domain.model

enum class Gender(val value: String) {
    ALL(""),
    MALE("Male"),
    FEMALE("Female"),
    GENDERLESS("Genderless"),
    UNKNOWN("unknown")
}
