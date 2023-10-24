package com.example.rickandmorty.data.mapper.character

import com.example.CharactersQuery
import com.example.rickandmorty.domain.character.CharactersResult

fun CharactersQuery.Characters.toCharactersResult(): CharactersResult {
    return CharactersResult(
        results = results
            ?.map { curCharacterResult ->
                curCharacterResult?.toCharacter()
            },
        info = info?.toInfo()
    )
}