package dev.application.pickle_rick.domain.usecase

import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject

class IsFavoriteCharacterSavedUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) : UseCase<String, Boolean>() {
    override suspend fun call(param: String): ClientResult<Boolean> {
        return ClientResult.Success(charactersRepository.isFavoriteCharacterSaved(param))
    }
}
