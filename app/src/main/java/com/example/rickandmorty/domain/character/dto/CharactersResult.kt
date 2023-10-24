package com.example.rickandmorty.domain.character.dto

data class CharactersResult(
    val results: List<Character?>?,
    val info: Info?,
)
