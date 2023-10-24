package com.example.rickandmorty.data.mapper.character

import com.example.CharactersQuery
import com.example.rickandmorty.domain.character.Info

fun CharactersQuery.Info.toInfo(): Info {
    return Info(
        count = count,
        next = next,
        pages = pages,
        prev = prev
    )
}