package dev.application.pickle_rick.presentation.screens.favorite_characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.application.pickle_rick.common.client_result.onError
import dev.application.pickle_rick.common.client_result.onSuccess
import dev.application.pickle_rick.domain.usecase.GetAllFavoriteCharactersUseCase
import dev.application.pickle_rick.domain.usecase.GetFavoriteCharactersIdsUseCase
import dev.application.pickle_rick.domain.usecase.RemoveFavoriteCharacterUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class FavoriteCharactersViewModel @Inject constructor(
    private val getAllFavoriteCharactersUseCase: GetAllFavoriteCharactersUseCase,
    private val removeFavoriteCharacterUseCase: RemoveFavoriteCharacterUseCase,
    private val getFavoriteCharactersIdsUseCase: GetFavoriteCharactersIdsUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(FavoriteCharactersState())
    val state = _state.asStateFlow()

    private val currentState: FavoriteCharactersState
        get() = state.value

    private fun setState(newState: FavoriteCharactersState) {
        _state.value = newState
    }

    fun loadCharacters() {
        viewModelScope.launch {
            setState(currentState.copy(isLoading = true, isError = null))
            getAllFavoriteCharactersUseCase.call(Unit)
                .onSuccess {
                    setState(currentState.copy(charactersList = it))
                }
                .onError {
                    setState(currentState.copy(isError = it))
                }
            setState(currentState.copy(isLoading = false))
        }
    }

    fun onLikeClicked(id: String) {
        viewModelScope.launch {
            removeFavoriteCharacterUseCase.call(id)
            val removeCharacter = currentState.charactersList.find { it.id == id }
            val list = currentState.charactersList.toMutableList()
            list.remove(removeCharacter)
            setState(currentState.copy(charactersList = list.toList()))
        }
    }

    fun updateFavoritesChanges() {
        viewModelScope.launch {
            val oldFavoriteIdsList = currentState.charactersList.map { it.id }
            getFavoriteCharactersIdsUseCase.call(Unit).onSuccess {
                val notFavoriteId = oldFavoriteIdsList - it.toSet()
                if (notFavoriteId.isNotEmpty()) {
                    notFavoriteId.forEach { id ->
                        val removeCharacter = currentState.charactersList.find { characterModel -> characterModel.id == id }
                        val newList = currentState.charactersList.toMutableList()
                        newList.remove(removeCharacter)
                        setState(currentState.copy(charactersList = newList))
                    }
                }
            }
        }
    }
}
