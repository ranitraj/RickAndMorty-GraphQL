package com.example.rickandmorty.data

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.Optional
import com.example.CharactersQuery
import com.example.rickandmorty.data.mapper.character.toCharactersResult
import com.example.rickandmorty.domain.character.CharacterClient
import com.example.rickandmorty.domain.character.dto.CharactersResult

class ApolloClient(
    private val apolloClient: ApolloClient
): CharacterClient {

    override suspend fun getCharacters(pageNumber: Int): CharactersResult {
        return apolloClient
            .query(CharactersQuery(page = Optional.present(pageNumber)))
            .execute()
            .data
            ?.characters
            ?.toCharactersResult() ?: CharactersResult(
                results = emptyList(),
                info = null
            )
    }

}