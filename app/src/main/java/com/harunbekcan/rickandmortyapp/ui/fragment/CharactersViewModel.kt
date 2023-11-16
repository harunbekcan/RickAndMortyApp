package com.harunbekcan.rickandmortyapp.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import com.harunbekcan.rickandmortyapp.domain.usecase.GetAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {

    private val _allCharacter = MutableStateFlow<PagingData<CharacterUiModel>>(PagingData.empty())
    val allCharacter = _allCharacter.asStateFlow()

    init {
        getAllCharacter()
    }

    private fun getAllCharacter() {
        viewModelScope.launch {
            getAllCharacterUseCase().onEach {
                _allCharacter.value = it
            }.cachedIn(viewModelScope)
        }
    }
}