package com.github.skytoph.currency.presentation.coin_details

import com.github.skytoph.currency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
