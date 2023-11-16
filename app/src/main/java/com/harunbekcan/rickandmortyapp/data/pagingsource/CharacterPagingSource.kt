package com.harunbekcan.rickandmortyapp.data.pagingsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.harunbekcan.rickandmortyapp.data.mapper.toCharacterUiModel
import com.harunbekcan.rickandmortyapp.data.remote.RickAndMortyApi
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import javax.inject.Inject

class CharacterPagingSource @Inject constructor (
    private val rickAndMortyApi: RickAndMortyApi
) : PagingSource<Int, CharacterUiModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterUiModel> {

        return try {
            val pageNumber = params.key ?: 1
            val response = rickAndMortyApi.getAllCharacter(pageNumber)
            val data = response.results?.takeIf { it.isNotEmpty() }?.map { it.toCharacterUiModel() } ?: emptyList()

            LoadResult.Page(
                data = data,
                prevKey = if (pageNumber > 1) pageNumber - 1 else null,
                nextKey = if (pageNumber < response.info.pages!!) pageNumber + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterUiModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}