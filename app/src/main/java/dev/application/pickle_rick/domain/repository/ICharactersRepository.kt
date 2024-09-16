package dev.application.pickle_rick.domain.repository

import androidx.paging.PagingData
import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters
import kotlinx.coroutines.flow.Flow

interface ICharactersRepository {
    fun getAllCharactersPages(filters: CharactersFilters): Flow<PagingData<CharacterModel>>
    suspend fun getAllFavoriteCharacters(): ClientResult<List<CharacterModel>>
    suspend fun getCharacterById(characterId: String): ClientResult<CharacterInfoModel>
    suspend fun saveFavoriteCharacter(characterId: String)
    suspend fun removeFavoriteCharacter(characterId: String)
    suspend fun isFavoriteCharacterSaved(characterId: String): Boolean
    suspend fun getFavoriteCharactersIds(): List<String>
}
