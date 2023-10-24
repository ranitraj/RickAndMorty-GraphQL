package com.example.rickandmorty.domain.character

import com.example.rickandmorty.domain.character.dto.CharactersResult

interface CharacterClient {
    suspend fun getCharacters(pageNumber: Int): CharactersResult
}