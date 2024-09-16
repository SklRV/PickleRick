package dev.application.pickle_rick.data.local

import dev.application.pickle_rick.data.local.db.FavoriteCharacterDao
import dev.application.pickle_rick.data.local.db.FavoriteCharacterEntity

class LocalDataSourceImpl(
    private val favoriteCharacterDao: FavoriteCharacterDao
) : ILocalDataSource {

    override suspend fun saveFavoriteCharacter(characterId: String) {
        val characterToInsert = FavoriteCharacterEntity(characterId)
        favoriteCharacterDao.insertFavoriteCharacter(characterToInsert)
    }

    override suspend fun removeFavoriteCharacter(characterId: String) {
        val characterToDelete = FavoriteCharacterEntity(characterId)
        favoriteCharacterDao.deleteFavoriteCharacter(characterToDelete)
    }

    override suspend fun isFavoriteCharacterSaved(characterId: String): Boolean {
        return favoriteCharacterDao.isFavoriteCharacterSaved(characterId)
    }

    override suspend fun getAllFavoriteCharactersIds(): List<String> {
        val charactersToInsert = favoriteCharacterDao.getAllFavoriteCharacters().map { it.id }
        return charactersToInsert
    }
}
