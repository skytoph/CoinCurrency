package com.github.skytoph.currency.domain.usecase.get_coins

import com.github.skytoph.currency.data.remote.dto.toCoin
import com.github.skytoph.currency.domain.model.Coin
import com.github.skytoph.currency.domain.repository.CoinRepository
import com.github.skytoph.currency.domain.usecase.FetchAndEmitCoins
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) : FetchAndEmitCoins<List<Coin>>() {

    override suspend fun fetch(coinId: String): List<Coin> =
        repository.getCoins().map { it.toCoin() }
}