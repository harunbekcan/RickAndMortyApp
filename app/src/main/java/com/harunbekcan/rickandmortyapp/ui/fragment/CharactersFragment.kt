package com.harunbekcan.rickandmortyapp.ui.fragment

import android.os.Bundle
import com.harunbekcan.rickandmortyapp.base.BaseFragment
import com.harunbekcan.rickandmortyapp.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : BaseFragment<FragmentCharactersBinding>(FragmentCharactersBinding::inflate) {
    override fun prepareView(savedInstanceState: Bundle?) {

    }
}