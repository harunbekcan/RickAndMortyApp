package com.harunbekcan.rickandmortyapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.harunbekcan.rickandmortyapp.base.BaseFragment
import com.harunbekcan.rickandmortyapp.databinding.FragmentCharactersBinding
import com.harunbekcan.rickandmortyapp.ui.adapter.CharactersPagingAdapter
import com.harunbekcan.rickandmortyapp.utils.collectFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>(FragmentCharactersBinding::inflate) {

    private lateinit var charactersPagingAdapter: CharactersPagingAdapter
    private val viewModel: CharactersViewModel by viewModels()
    override fun prepareView(savedInstanceState: Bundle?) {
        initPagingAdapter()
        pagingDataObserve()
    }

    private fun initPagingAdapter() {
        charactersPagingAdapter = CharactersPagingAdapter()
        binding.charactersRecyclerView.adapter = charactersPagingAdapter
    }

    private fun pagingDataObserve(){
        this.collectFlow(viewModel.allCharacter) {
            charactersPagingAdapter.submitData(it)
        }
    }
}