package com.github.skytoph.currency.presentation.coin_list

import com.github.skytoph.currency.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
