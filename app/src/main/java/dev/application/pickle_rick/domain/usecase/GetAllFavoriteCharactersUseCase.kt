package dev.application.pickle_rick.domain.usecase

import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject

class GetAllFavoriteCharactersUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) : UseCase<Unit, List<CharacterModel>>() {
    override suspend fun call(param: Unit): ClientResult<List<CharacterModel>> {
        return charactersRepository.getAllFavoriteCharacters()
    }
}
