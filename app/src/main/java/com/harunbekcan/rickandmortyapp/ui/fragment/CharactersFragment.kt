package com.harunbekcan.rickandmortyapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import com.harunbekcan.rickandmortyapp.R
import com.harunbekcan.rickandmortyapp.databinding.FragmentCharactersBinding
import com.harunbekcan.rickandmortyapp.ui.adapter.CharactersPagingAdapter
import com.harunbekcan.rickandmortyapp.utils.collectFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment(R.layout.fragment_characters) {

    private var _binding : FragmentCharactersBinding ?= null
    private val binding get() = _binding!!

    private val charactersPagingAdapter = CharactersPagingAdapter()
    private val viewModel: CharactersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentCharactersBinding.bind(view)
        initPagingAdapter()
        initProgressBar()
        pagingDataObserve()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initPagingAdapter() {
        binding.charactersRecyclerView.adapter = charactersPagingAdapter
    }

    private fun initProgressBar(){
        charactersPagingAdapter.addLoadStateListener {
            binding.charactersRecyclerView.isVisible = it.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = it.refresh is LoadState.Loading
        }
    }

    private fun pagingDataObserve(){
        collectFlow(viewModel.allCharacterData) {
            charactersPagingAdapter.submitData(it)
        }
    }
}