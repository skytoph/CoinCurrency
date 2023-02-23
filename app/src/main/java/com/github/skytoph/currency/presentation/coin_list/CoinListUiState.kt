package com.github.skytoph.currency.presentation.coin_list

import com.github.skytoph.currency.core.Communication
import com.github.skytoph.currency.domain.model.Coin

sealed class CoinListUiState {
    abstract fun show(state: Communication.Show<CoinListState>)

    class Success(private val data: List<Coin>) : CoinListUiState() {
        override fun show(state: Communication.Show<CoinListState>) {
            state.show(CoinListState(coins = data))
        }
    }

    object Loading : CoinListUiState() {
        override fun show(state: Communication.Show<CoinListState>) {
            state.show(CoinListState(isLoading = true))
        }
    }

    class Error(private val message: String) : CoinListUiState() {
        override fun show(state: Communication.Show<CoinListState>) {
            state.show(CoinListState(error = message))
        }
    }
}