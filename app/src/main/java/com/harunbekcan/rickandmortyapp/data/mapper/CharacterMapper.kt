package com.harunbekcan.rickandmortyapp.data.mapper

import com.harunbekcan.rickandmortyapp.data.response.CharacterResult
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import com.harunbekcan.rickandmortyapp.utils.orZero


fun CharacterResult.toCharacterUiModel() = CharacterUiModel(
    id = id.orZero(),
    name = name.orEmpty(),
    image = image.orEmpty()
)