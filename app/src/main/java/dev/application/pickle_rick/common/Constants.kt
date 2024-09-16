package dev.application.pickle_rick.common

// GraphQLClient
const val BASE_URL = "https://rickandmortyapi.com/graphql"
const val MEMORY_CACHE_10_MB = 10 * 1024 * 1024

// RemoteDataSourceImpl
const val PAGE_SIZE = 20
const val PREFETCH_DISTANCE = 25
const val INITIAL_LOAD_SIZE = 10

// Parameters
const val CHARACTER_ID = "characterId"

// Routes
const val CHARACTERS = "Characters"
const val FAVORITE = "Favorite"
const val CHARACTERS_INFO = "CharacterInfo"

// Statuses
const val STATUS_ALIVE = "Alive"
const val STATUS_DEAD = "Dead"
const val EMPTY_CHARACTERS_LIST = "Empty characters list"
