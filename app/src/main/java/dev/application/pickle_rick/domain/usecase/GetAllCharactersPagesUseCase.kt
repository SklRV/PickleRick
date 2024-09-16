package dev.application.pickle_rick.domain.usecase

import androidx.paging.PagingData
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class GetAllCharactersPagesUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) {
    fun call(filters: CharactersFilters): Flow<PagingData<CharacterModel>> {
        return charactersRepository.getAllCharactersPages(filters).flowOn(Dispatchers.IO)
    }
}
