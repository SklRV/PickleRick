package dev.application.pickle_rick.domain.usecase

import dev.application.pickle_rick.common.client_result.ClientResult
import dev.application.pickle_rick.domain.model.CharacterInfoModel
import dev.application.pickle_rick.domain.repository.ICharactersRepository
import javax.inject.Inject

class GetCharacterByIdUseCase @Inject constructor(
    private val charactersRepository: ICharactersRepository
) : UseCase<String, CharacterInfoModel?>() {
    override suspend fun call(param: String): ClientResult<CharacterInfoModel> {
        return charactersRepository.getCharacterById(param)
    }
}
