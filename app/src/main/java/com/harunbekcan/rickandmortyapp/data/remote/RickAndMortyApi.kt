package com.harunbekcan.rickandmortyapp.data.remote

import com.harunbekcan.rickandmortyapp.data.response.CharacterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ): CharacterResponse
}