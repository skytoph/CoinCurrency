package com.github.skytoph.currency.data.remote

import com.github.skytoph.currency.data.remote.dto.CoinDTO
import com.github.skytoph.currency.data.remote.dto.CoinDetailDTO
import com.github.skytoph.currency.domain.repository.FetchCoins
import javax.inject.Inject

interface CoinRemoteDataSource : FetchCoins {

    class Base @Inject constructor(private val api: CoinApi) : CoinRemoteDataSource {

        override suspend fun getCoins(): List<CoinDTO> =
            api.getCoins()

        override suspend fun getCoinById(coinId: String): CoinDetailDTO =
            api.getCoinById(coinId)
    }
}