package com.harunbekcan.rickandmortyapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.harunbekcan.rickandmortyapp.data.pagingsource.CharacterPagingSource
import com.harunbekcan.rickandmortyapp.data.remote.RickAndMortyApi
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import com.harunbekcan.rickandmortyapp.domain.repository.CharacterRepository
import com.harunbekcan.rickandmortyapp.utils.Constants.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(private val rickAndMortyApi: RickAndMortyApi) :
    CharacterRepository {

    override fun getAllCharacter(): Flow<PagingData<CharacterUiModel>> {
        return Pager(
            config = PagingConfig(pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = {
                CharacterPagingSource(rickAndMortyApi)
            }
        ).flow
    }
}