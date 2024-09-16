package dev.application.pickle_rick.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import dev.application.pickle_rick.R
import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.common.client_result.DataSourceException
import dev.application.pickle_rick.data.local.ILocalDataSource
import dev.application.pickle_rick.data.remote.IRemoteDataSource
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
) : ICharactersRepository {

    override fun getAllCharactersPages(filters: CharactersFilters): Flow<PagingData<CharacterModel>> {
        return remoteDataSource.getAllCharactersPages(filters).flow.map { character ->
            character.map {
                val isFavorite = localDataSource.isFavoriteCharacterSaved(it.id)
                it.copy(favorite = isFavorite)
            }
        }
    }

    override suspend fun getAllFavoriteCharacters(): ClientResult<List<CharacterModel>> {
        val localData = localDataSource.getAllFavoriteCharactersIds()
        return if (localData.isNotEmpty()) {
            remoteDataSource.getAllFavoriteCharacters(localData)
        } else {
            ClientResult.Error(DataSourceException.Unexpected(R.string.have_not_favorite_characters))
        }
    }

    override suspend fun getCharacterById(characterId: String): ClientResult<CharacterInfoModel> {
        val data = remoteDataSource.getCharacterById(characterId)
        if (data is ClientResult.Success) {
            val isFavorite = localDataSource.isFavoriteCharacterSaved(characterId)
            return if (isFavorite) {
                val favoriteData = data.data.copy(favorite = true)
                ClientResult.Success(favoriteData)
            } else {
                data
            }
        } else {
            return data
        }
    }

    override suspend fun saveFavoriteCharacter(characterId: String) {
        return localDataSource.saveFavoriteCharacter(characterId)
    }

    override suspend fun removeFavoriteCharacter(characterId: String) {
        return localDataSource.removeFavoriteCharacter(characterId)
    }

    override suspend fun isFavoriteCharacterSaved(characterId: String): Boolean {
        return localDataSource.isFavoriteCharacterSaved(characterId)
    }

    override suspend fun getFavoriteCharactersIds(): List<String> {
        return localDataSource.getAllFavoriteCharactersIds()
    }
}
