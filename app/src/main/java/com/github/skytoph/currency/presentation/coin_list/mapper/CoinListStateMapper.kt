package com.github.skytoph.currency.presentation.coin_list.mapper

import com.github.skytoph.currency.core.ActionResult
import com.github.skytoph.currency.domain.model.Coin
import com.github.skytoph.currency.presentation.coin_list.CoinListUiState
import javax.inject.Inject

interface CoinListStateMapper {
    fun map(data: ActionResult<List<Coin>>): CoinListUiState

    class Base @Inject constructor() : CoinListStateMapper {
        override fun map(data: ActionResult<List<Coin>>): CoinListUiState = when (data) {
            is ActionResult.Success -> CoinListUiState.Success(data.data ?: emptyList())
            is ActionResult.Loading -> CoinListUiState.Loading
            is ActionResult.Error -> CoinListUiState.Error(
                data.message ?: "An unexpected error occurred"
            )
        }
    }
}