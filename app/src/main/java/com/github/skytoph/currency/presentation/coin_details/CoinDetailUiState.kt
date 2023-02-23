package com.github.skytoph.currency.presentation.coin_details

import com.github.skytoph.currency.core.Communication
import com.github.skytoph.currency.domain.model.CoinDetail

sealed class CoinDetailUiState {
    abstract fun show(communication: Communication.Show<CoinDetailState>)

    class Success(private val data: CoinDetail) : CoinDetailUiState() {
        override fun show(communication: Communication.Show<CoinDetailState>) {
            communication.show(CoinDetailState(coin = data))
        }
    }

    object Loading : CoinDetailUiState() {
        override fun show(communication: Communication.Show<CoinDetailState>) {
            communication.show(CoinDetailState(isLoading = true))
        }
    }

    class Error(private val message: String) : CoinDetailUiState() {
        override fun show(communication: Communication.Show<CoinDetailState>) {
            communication.show(CoinDetailState(error = message))
        }
    }
}