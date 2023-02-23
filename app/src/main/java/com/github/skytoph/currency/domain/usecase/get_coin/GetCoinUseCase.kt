package com.github.skytoph.currency.domain.usecase.get_coin

import com.github.skytoph.currency.data.remote.dto.toCoinDetail
import com.github.skytoph.currency.domain.model.CoinDetail
import com.github.skytoph.currency.domain.repository.CoinRepository
import com.github.skytoph.currency.domain.usecase.FetchAndEmitCoins
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) : FetchAndEmitCoins<CoinDetail>() {

    override suspend fun fetch(coinId: String): CoinDetail =
        repository.getCoinById(coinId).toCoinDetail()
}

