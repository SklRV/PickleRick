package dev.application.pickle_rick.data.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import dev.application.pickle_rick.R
import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.common.client_result.DataSourceException
import dev.application.pickle_rick.data.remote.graphql_client.GraphQLClient
import dev.application.pickle_rick.data.mapper.toCharacterInfoModel
import dev.application.pickle_rick.data.mapper.toCharacterModel
import dev.application.pickle_rick.data.remote.paging.GetAllCharactersPagingSource
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.common.INITIAL_LOAD_SIZE
import dev.application.pickle_rick.common.PAGE_SIZE
import dev.application.pickle_rick.common.PREFETCH_DISTANCE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteDataSourceImpl(
    private val graphqlClient: GraphQLClient
) : IRemoteDataSource {

    override fun getAllCharactersPages(filters: CharactersFilters): Pager<Int, CharacterModel> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                prefetchDistance = PREFETCH_DISTANCE,
                initialLoadSize = INITIAL_LOAD_SIZE
            ),
            pagingSourceFactory = { GetAllCharactersPagingSource(graphqlClient, filters) })
    }

    override suspend fun getAllFavoriteCharacters(listCharacterId: List<String>): ClientResult<List<CharacterModel>> {
        return withContext(Dispatchers.IO) {
            try {
                val result = graphqlClient.getAllFavoriteCharacters(listCharacterId)
                val data = result.data?.charactersByIds
                if (!data.isNullOrEmpty()) {
                    ClientResult.Success(data.map { it?.toCharacterModel() ?: CharacterModel() })
                } else {
                    ClientResult.Error(DataSourceException.Server(result.errors?.first()))
                }
            } catch (e: Exception) {
                ClientResult.Error(DataSourceException.Unexpected(R.string.error_text))
            }
        }
    }

    override suspend fun getCharacterById(characterId: String): ClientResult<CharacterInfoModel> {
        return withContext(Dispatchers.IO) {
            try {
                val result = graphqlClient.getCharacterById(characterId)
                val data = result.data?.character
                if (data != null) {
                    ClientResult.Success(data.toCharacterInfoModel())
                } else {
                    ClientResult.Error(DataSourceException.Server(result.errors?.first()))
                }
            } catch (e: Exception) {
                ClientResult.Error(DataSourceException.Unexpected(R.string.error_text))
            }
        }
    }
}
