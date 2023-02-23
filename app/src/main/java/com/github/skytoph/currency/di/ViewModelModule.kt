package com.github.skytoph.currency.di

import com.github.skytoph.currency.presentation.coin_details.CoinStateCommunication
import com.github.skytoph.currency.presentation.coin_details.mapper.CoinStateMapper
import com.github.skytoph.currency.presentation.coin_list.CoinListStateCommunication
import com.github.skytoph.currency.presentation.coin_list.mapper.CoinListStateMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface ViewModelModule {

    @Binds
    @ViewModelScoped
    fun coinCommunication(state: CoinStateCommunication.Base): CoinStateCommunication

    @Binds
    @ViewModelScoped
    fun coinListCommunication(state: CoinListStateCommunication.Base): CoinListStateCommunication

    @Binds
    @ViewModelScoped
    fun coinListMapper(mapper: CoinListStateMapper.Base): CoinListStateMapper

    @Binds
    @ViewModelScoped
    fun coinMapper(mapper: CoinStateMapper.Base): CoinStateMapper
}