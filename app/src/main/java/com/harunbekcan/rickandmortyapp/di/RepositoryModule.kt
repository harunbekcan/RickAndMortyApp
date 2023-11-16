package com.harunbekcan.rickandmortyapp.di

import com.harunbekcan.rickandmortyapp.data.repository.CharacterRepositoryImpl
import com.harunbekcan.rickandmortyapp.domain.repository.CharacterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsCharacterRepository(characterRepositoryImpl: CharacterRepositoryImpl): CharacterRepository
}