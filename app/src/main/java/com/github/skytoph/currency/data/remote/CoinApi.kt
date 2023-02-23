package com.github.skytoph.currency.data.remote

import com.github.skytoph.currency.data.remote.dto.CoinDTO
import com.github.skytoph.currency.data.remote.dto.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDyId(@Path("coinId") coinId: String): CoinDetailDTO
}