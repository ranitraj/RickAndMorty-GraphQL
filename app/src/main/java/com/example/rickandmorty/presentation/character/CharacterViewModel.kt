package com.example.rickandmorty.presentation.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmorty.domain.character.dto.Character
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

    // State Data Class
    data class CharactersState(
        val charactersResult: CharactersResult? = CharactersResult(
            emptyList(),
            info = null
        ),
        val isLoading: Boolean = false
    )

    init {
        // Initially, set 'isLoading' flag to 'true' & then make API call to get characters
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

}