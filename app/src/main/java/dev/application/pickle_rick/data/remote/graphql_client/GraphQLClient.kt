package dev.application.pickle_rick.data.remote.graphql_client

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Optional
import com.apollographql.apollo3.api.Query
import dev.application.AllCharactersPagesQuery
import dev.application.AllCharactersPagesQuery.Data
import dev.application.AllFavoriteCharactersQuery
import dev.application.CharacterByIdQuery
import dev.application.pickle_rick.domain.model.CharactersFilters
import javax.inject.Inject

class GraphQLClient @Inject constructor(
    private val apolloClient: ApolloClient
) {

    private suspend fun <D : Query.Data> proceedQuery(query: Query<D>): ApolloResponse<D> {
        return apolloClient.query(query).execute()
    }

    suspend fun getAllCharactersPages(page: Int, filter: CharactersFilters): ApolloResponse<Data> {
        return proceedQuery(
            AllCharactersPagesQuery(
                Optional.presentIfNotNull(page),
                gender = Optional.presentIfNotNull(filter.gender.value),
                status = Optional.presentIfNotNull(filter.status.value)
            )
        )
    }

    suspend fun getAllFavoriteCharacters(ids: List<String>): ApolloResponse<AllFavoriteCharactersQuery.Data> {
        return proceedQuery(AllFavoriteCharactersQuery(ids))
    }

    suspend fun getCharacterById(id: String): ApolloResponse<CharacterByIdQuery.Data> {
        return proceedQuery(CharacterByIdQuery(id))
    }
}
