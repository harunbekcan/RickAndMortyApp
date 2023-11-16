package com.harunbekcan.rickandmortyapp.domain.repository

import androidx.paging.PagingData
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import kotlinx.coroutines.flow.Flow

interface CharacterRepository {

    fun getAllCharacter(): Flow<PagingData<CharacterUiModel>>
}