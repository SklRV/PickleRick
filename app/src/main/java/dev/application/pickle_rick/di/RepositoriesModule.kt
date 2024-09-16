package dev.application.pickle_rick.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.application.pickle_rick.data.remote.graphql_client.GraphQLClient
import dev.application.pickle_rick.data.local.ILocalDataSource
import dev.application.pickle_rick.data.local.LocalDataSourceImpl
import dev.application.pickle_rick.data.local.db.FavoriteCharacterDao
import dev.application.pickle_rick.data.remote.IRemoteDataSource
import dev.application.pickle_rick.data.remote.RemoteDataSourceImpl
import dev.application.pickle_rick.data.repository.CharactersRepositoryImpl
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoriesModule {

    @Provides
    @Singleton
    fun provideRemoteDataSource(graphqlClient: GraphQLClient): IRemoteDataSource {
        return RemoteDataSourceImpl(graphqlClient)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(favoriteCharacterDao: FavoriteCharacterDao): ILocalDataSource {
        return LocalDataSourceImpl(favoriteCharacterDao)
    }

    @Provides
    @Singleton
    fun provideCharactersRepository(
        iRemoteDataSource: IRemoteDataSource,
        localDataSource: ILocalDataSource
    ): ICharactersRepository {
        return CharactersRepositoryImpl(remoteDataSource = iRemoteDataSource, localDataSource = localDataSource)
    }
}
