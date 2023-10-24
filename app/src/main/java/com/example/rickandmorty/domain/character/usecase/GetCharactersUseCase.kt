package com.example.rickandmorty.domain.character.usecase

import com.example.rickandmorty.domain.character.CharacterClient
import com.example.rickandmorty.domain.character.dto.CharactersResult

class GetCharactersUseCase(
    private val characterClient: CharacterClient
) {
    suspend fun execute(pageNumber: Int): CharactersResult? {
        return characterClient
            .getCharacters(pageNumber)
    }
}