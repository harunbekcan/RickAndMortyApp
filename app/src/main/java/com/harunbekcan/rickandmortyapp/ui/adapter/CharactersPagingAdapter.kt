package com.harunbekcan.rickandmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.harunbekcan.rickandmortyapp.databinding.ItemCharacterBinding
import com.harunbekcan.rickandmortyapp.domain.model.CharacterUiModel

class CharactersPagingAdapter : PagingDataAdapter<CharacterUiModel, CharactersViewHolder>(DiffUtils) {

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        val character = getItem(position)
        character?.let {
            holder.bind(data = it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    object DiffUtils : DiffUtil.ItemCallback<CharacterUiModel>() {
        override fun areItemsTheSame(
            oldItem: CharacterUiModel,
            newItem: CharacterUiModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterUiModel,
            newItem: CharacterUiModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}