package dev.application.pickle_rick.presentation.screens.character_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.application.pickle_rick.common.client_result.onError
import dev.application.pickle_rick.common.client_result.onSuccess
import dev.application.pickle_rick.domain.usecase.GetCharacterByIdUseCase
import dev.application.pickle_rick.domain.usecase.RemoveFavoriteCharacterUseCase
import dev.application.pickle_rick.domain.usecase.SaveFavoriteCharacterUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CharacterInfoViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val saveFavoriteCharacterUseCase: SaveFavoriteCharacterUseCase,
    private val removeFavoriteCharacterUseCase: RemoveFavoriteCharacterUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterInfoState())
    val state = _state.asStateFlow()

    private val currentState: CharacterInfoState
        get() = state.value

    private fun setState(newState: CharacterInfoState) {
        _state.value = newState
    }

    fun loadCharacter(characterId: String) {
        viewModelScope.launch {
            setState(currentState.copy(isLoading = true, isError = false))
            getCharacterByIdUseCase.call(characterId)
                .onSuccess {
                    setState(currentState.copy(characterInfo = it))
                }
                .onError {
                    setState(currentState.copy(isError = true))
                }
            setState(currentState.copy(isLoading = false))
        }
    }

    fun onLikeClicked() {
        val oldFavorite = currentState.characterInfo.favorite
        setState(currentState.copy(characterInfo = currentState.characterInfo.copy(favorite = !oldFavorite)))
        viewModelScope.launch {
            if (oldFavorite) {
                removeFavoriteCharacterUseCase.call(currentState.characterInfo.id)
            } else {
                saveFavoriteCharacterUseCase.call(currentState.characterInfo.id)
            }
        }
    }
}
