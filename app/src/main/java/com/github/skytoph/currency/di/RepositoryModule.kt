package com.github.skytoph.currency.di

import com.github.skytoph.currency.data.remote.CoinRemoteDataSource
import com.github.skytoph.currency.data.repository.BaseCoinRepository
import com.github.skytoph.currency.domain.repository.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun coinRepository(repo: BaseCoinRepository): CoinRepository

    @Binds
    fun coinRemote(datasource: CoinRemoteDataSource.Base): CoinRemoteDataSource
}