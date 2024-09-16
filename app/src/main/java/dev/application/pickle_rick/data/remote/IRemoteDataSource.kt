package dev.application.pickle_rick.data.remote

import androidx.paging.Pager
import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters

interface IRemoteDataSource {
    fun getAllCharactersPages(filters: CharactersFilters): Pager<Int, CharacterModel>
    suspend fun getAllFavoriteCharacters(listCharacterId: List<String>): ClientResult<List<CharacterModel>>
    suspend fun getCharacterById(characterId: String): ClientResult<CharacterInfoModel>
}
