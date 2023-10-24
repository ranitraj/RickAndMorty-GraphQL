package com.example.rickandmorty.data.mapper.character

import com.example.CharactersQuery
import com.example.rickandmorty.domain.character.Character

fun CharactersQuery.Result.toCharacter(): Character {
    return Character(
        image = image,
        gender = gender,
        name = name,
        status = status,
        species = species
    )
}