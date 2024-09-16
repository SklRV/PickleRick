package dev.application.pickle_rick.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.cache.normalized.api.MemoryCacheFactory
import com.apollographql.apollo3.cache.normalized.normalizedCache
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.application.pickle_rick.common.BASE_URL
import dev.application.pickle_rick.common.MEMORY_CACHE_10_MB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        val cacheFactory = MemoryCacheFactory(maxSizeBytes = MEMORY_CACHE_10_MB)
        return ApolloClient.Builder().serverUrl(BASE_URL).normalizedCache(cacheFactory).build()
    }
}
