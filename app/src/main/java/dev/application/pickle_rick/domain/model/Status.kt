package dev.application.pickle_rick.domain.model

enum class Status(val value: String) {
    ALL(""),
    ALIVE("Alive"),
    DEAD("Dead"),
    UNKNOWN("unknown")
}
