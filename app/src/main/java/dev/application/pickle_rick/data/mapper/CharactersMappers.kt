package dev.application.pickle_rick.data.mapper

import dev.application.AllCharactersPagesQuery
import dev.application.AllFavoriteCharactersQuery
import dev.application.CharacterByIdQuery
import dev.application.pickle_rick.domain.model.CharacterEpisodesModel
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.domain.model.CharacterModel

fun AllCharactersPagesQuery.Result.toCharacterModel(): CharacterModel {
    return with(characterFragment) {
        CharacterModel(
            id = id ?: "",
            name = name ?: "",
            species = species ?: "",
            status = status ?: "",
            gender = gender ?: "",
            image = image ?: "",
            favorite = false
        )
    }
}

fun AllFavoriteCharactersQuery.CharactersById.toCharacterModel(): CharacterModel {
    return with(characterFragment) {
        CharacterModel(
            id = id ?: "",
            name = name ?: "",
            species = species ?: "",
            status = status ?: "",
            gender = gender ?: "",
            image = image ?: "",
            favorite = true
        )
    }
}

fun CharacterByIdQuery.Character.toCharacterInfoModel(): CharacterInfoModel {
    return CharacterInfoModel(
        id = characterFragment.id ?: "",
        name = characterFragment.name ?: "",
        status = characterFragment.status ?: "",
        species = characterFragment.species ?: "",
        gender = characterFragment.gender ?: "",
        image = characterFragment.image ?: "",
        type = if (!type.isNullOrEmpty()) type else "-----",
        originLocation = origin?.name ?: "",
        lastLocation = location?.name ?: "",
        episodes = episode.map { it?.toCharacterEpisodesModel() ?: CharacterEpisodesModel() },
        favorite = false
    )
}

fun CharacterByIdQuery.Episode.toCharacterEpisodesModel(): CharacterEpisodesModel {
    return CharacterEpisodesModel(
        name = name ?: "",
        airDate = air_date ?: "",
    )
}
