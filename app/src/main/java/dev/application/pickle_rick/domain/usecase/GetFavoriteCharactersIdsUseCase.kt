package dev.application.pickle_rick.domain.usecase

import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject

class GetFavoriteCharactersIdsUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) : UseCase<Unit, List<String>>() {
    override suspend fun call(param: Unit): ClientResult<List<String>> {
        return ClientResult.Success(charactersRepository.getFavoriteCharactersIds())
    }
}
