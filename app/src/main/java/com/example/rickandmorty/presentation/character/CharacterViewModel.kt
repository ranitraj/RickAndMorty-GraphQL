package com.example.rickandmorty.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.character.dto.CharactersResult
import com.example.rickandmorty.domain.character.usecase.GetCharactersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase
): ViewModel() {

    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()    // UI has immutable state of the StateFlow & only ViewModel can change it

    /**
     * Data Class comprising of parameters defining the State of the CharactersResult
     */
    data class CharactersState(
        val charactersResult: CharactersResult = CharactersResult(
            emptyList(),
            info = null
        ),
        val isLoading: Boolean = false
    )

    /**
     * Initially, set 'isLoading' flag to 'true' & then make API call to get initial
     * set of characters by passing '1' as the pageNumber
     */
    init {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            _state.update {
                it.copy(
                    charactersResult = getCharactersUseCase.execute(1),
                    isLoading = false
                )
            }
        }
    }

    /**
     * Fetches the response from the CharactersQuery.CharactersResult API by making
     * use of the parameter 'pageNumber' for Pagination
     *
     * @param pageNumber - pageCount for current response
     */
    fun getCharacters(pageNumber: Int) {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    charactersResult = getCharactersUseCase.execute(pageNumber),
                    isLoading = false
                )
            }
        }
    }

}