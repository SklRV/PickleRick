package dev.application.pickle_rick.data.remote.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.application.pickle_rick.data.remote.graphql_client.GraphQLClient
import dev.application.pickle_rick.data.mapper.toCharacterModel
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.common.EMPTY_CHARACTERS_LIST

class GetAllCharactersPagingSource(
    private val apolloClient: GraphQLClient,
    private val filters: CharactersFilters,
) : PagingSource<Int, CharacterModel>() {

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { state.closestPageToPosition(it)?.nextKey }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        return try {
            val pageNumber = params.key ?: 0
            val response = apolloClient.getAllCharactersPages(pageNumber, filters)
            val result = response.data?.characters?.results
            val list = result?.mapNotNull { it?.toCharacterModel() }

            val prevKey = if (pageNumber > 0) pageNumber - 1 else null
            val nextKey = response.data?.characters?.info?.next

            if (list != null)
                LoadResult.Page(data = list, prevKey = prevKey, nextKey = nextKey)
            else
                LoadResult.Error(Throwable(message = EMPTY_CHARACTERS_LIST))

        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}
