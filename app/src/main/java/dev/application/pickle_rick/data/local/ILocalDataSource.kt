package dev.application.pickle_rick.data.local

interface ILocalDataSource {
    suspend fun saveFavoriteCharacter(characterId: String)
    suspend fun removeFavoriteCharacter(characterId: String)
    suspend fun isFavoriteCharacterSaved(characterId: String): Boolean
    suspend fun getAllFavoriteCharactersIds(): List<String>
}
