package com.example.rickandmorty.domain.character

/**
 * Pagination Support for Character API
 */
data class Info(
    val count: Int?,    // Length of the response
    val next: Int?,     // Number of the next page (if it exists)
    val pages: Int?,    // Amount of pages
    val prev: Int?      // Number of the previous page (if it exists)
)
