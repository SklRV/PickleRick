package dev.application.pickle_rick.presentation.screens.all_characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.application.pickle_rick.common.client_result.onSuccess
import dev.application.pickle_rick.domain.model.CharacterModel
import dev.application.pickle_rick.domain.model.CharactersFilters
import dev.application.pickle_rick.domain.usecase.GetAllCharactersPagesUseCase
import dev.application.pickle_rick.domain.usecase.GetFavoriteCharactersIdsUseCase
import dev.application.pickle_rick.domain.usecase.IsFavoriteCharacterSavedUseCase
import dev.application.pickle_rick.domain.usecase.RemoveFavoriteCharacterUseCase
import dev.application.pickle_rick.domain.usecase.SaveFavoriteCharacterUseCase
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AllCharactersViewModel @Inject constructor(
    private val getAllCharactersPagesUseCase: GetAllCharactersPagesUseCase,
    private val removeFavoriteCharacterUseCase: RemoveFavoriteCharacterUseCase,
    private val saveFavoriteCharacterUseCase: SaveFavoriteCharacterUseCase,
    private val isFavoriteCharacterSavedUseCase: IsFavoriteCharacterSavedUseCase,
    private val getFavoriteCharactersIdsUseCase: GetFavoriteCharactersIdsUseCase,
) : ViewModel() {

    private val _allCharactersState: MutableStateFlow<PagingData<CharacterModel>> = MutableStateFlow(value = PagingData.empty())
    val allCharactersState: MutableStateFlow<PagingData<CharacterModel>>
        get() = _allCharactersState

    private val _state = MutableStateFlow(AllCharactersState())
    val state = _state.asStateFlow()

    private val currentState: AllCharactersState
        get() = state.value

    private fun setState(newState: AllCharactersState) {
        _state.value = newState
    }

    private var saveFilters = CharactersFilters()
    fun checkFilters(filter: CharactersFilters) {
        if (saveFilters != filter) {
            saveFilters = filter
            getAllCharacters(filter)
        }
    }

    init {
        getAllCharacters(saveFilters)
    }

    fun getAllCharacters(filters: CharactersFilters) {
        _allCharactersState.value = PagingData.empty()
        viewModelScope.launch {
            getAllCharactersPagesUseCase.call(filters)
                .cachedIn(viewModelScope)
                .collect {
                    _allCharactersState.value = it
                }
        }
    }

    fun onLikeClicked(id: String) {
        viewModelScope.launch {
            isFavoriteCharacterSavedUseCase.call(id).onSuccess { isFavoriteCharacterSaved ->
                val newList = currentState.favoriteIdsList.toMutableList()
                if (isFavoriteCharacterSaved) {
                    removeFavoriteCharacterUseCase.call(id)
                    newList.remove(id)
                } else {
                    saveFavoriteCharacterUseCase.call(id)
                    newList.add(id)
                }
                setState(currentState.copy(favoriteIdsList = newList))
            }
        }
    }

    fun updateFavoritesChanges() {
        viewModelScope.launch {
            getFavoriteCharactersIdsUseCase.call(Unit)
                .onSuccess { setState(currentState.copy(favoriteIdsList = it)) }
        }
    }
}
