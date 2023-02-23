package com.github.skytoph.currency.presentation.coin_details.mapper

import com.github.skytoph.currency.core.ActionResult
import com.github.skytoph.currency.domain.model.CoinDetail
import com.github.skytoph.currency.presentation.coin_details.CoinDetailUiState
import javax.inject.Inject

interface CoinStateMapper {
    fun map(data: ActionResult<CoinDetail>): CoinDetailUiState

    class Base @Inject constructor() : CoinStateMapper {
        override fun map(data: ActionResult<CoinDetail>): CoinDetailUiState = when (data) {
            is ActionResult.Success -> CoinDetailUiState.Success(data.data!!)
            is ActionResult.Loading -> CoinDetailUiState.Loading
            is ActionResult.Error -> CoinDetailUiState.Error(
                data.message ?: "An unexpected error occurred"
            )
        }
    }
}