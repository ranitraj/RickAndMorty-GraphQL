package com.example.rickandmorty.data.mapper.character

import com.example.CharactersQuery
import com.example.rickandmorty.domain.character.Character
import com.example.rickandmorty.domain.character.CharactersResult
import com.example.rickandmorty.domain.character.Info


fun CharactersQuery.Characters.toCharactersResult(): CharactersResult {
    return CharactersResult(
        results = results
            ?.map { curCharacterResult ->
                curCharacterResult?.toCharacter()
            },
        info = info?.toInfo()
    )
}

fun CharactersQuery.Result.toCharacter(): Character {
    return Character(
        image = image,
        gender = gender,
        name = name,
        status = status,
        species = species
    )
}
fun CharactersQuery.Info.toInfo(): Info {
    return Info(
        count = count,
        next = next,
        pages = pages,
        prev = prev
    )
}