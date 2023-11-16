package com.harunbekcan.rickandmortyapp.domain.usecase

import androidx.paging.PagingData
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import com.harunbekcan.rickandmortyapp.domain.repository.CharacterRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(private val characterRepository: CharacterRepository) {

    operator fun invoke(): Flow<PagingData<CharacterUiModel>> {
        return characterRepository.getAllCharacter()
    }
}