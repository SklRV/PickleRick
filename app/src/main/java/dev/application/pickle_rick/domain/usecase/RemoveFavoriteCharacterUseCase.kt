package dev.application.pickle_rick.domain.usecase

import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject

class RemoveFavoriteCharacterUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) : UseCase<String, Unit>() {
    override suspend fun call(param: String): ClientResult<Unit> {
        return ClientResult.Success(charactersRepository.removeFavoriteCharacter(param))
    }
}
