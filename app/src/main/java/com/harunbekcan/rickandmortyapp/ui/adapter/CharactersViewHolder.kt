package com.harunbekcan.rickandmortyapp.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.harunbekcan.rickandmortyapp.databinding.ItemCharacterBinding
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel
import com.harunbekcan.rickandmortyapp.utils.loadImageCircle

class CharactersViewHolder(
    private val binding: ItemCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data: CharacterUiModel) {
        binding.characterNameTextView.text = data.name
        binding.characterImageView.loadImageCircle(data.image)
    }
}