package com.example.rickandmorty.domain.character

interface CharacterClient {
    suspend fun getCharacters(pageNumber: Int): CharactersResult
}