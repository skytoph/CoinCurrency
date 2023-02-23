package com.github.skytoph.currency.data.repository

import com.github.skytoph.currency.data.remote.RemoteDataSource
import com.github.skytoph.currency.data.remote.dto.CoinDTO
import com.github.skytoph.currency.data.remote.dto.CoinDetailDTO
import com.github.skytoph.currency.domain.repository.CoinRepository
import javax.inject.Inject

class BaseCoinRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDTO> =
        remoteDataSource.getCoins()

    override suspend fun getCoinById(coinId: String): CoinDetailDTO =
        remoteDataSource.getCoinById(coinId)
}