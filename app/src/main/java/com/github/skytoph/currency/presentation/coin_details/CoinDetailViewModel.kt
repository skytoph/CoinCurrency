package com.github.skytoph.currency.presentation.coin_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.skytoph.currency.core.Constants
import com.github.skytoph.currency.domain.usecase.get_coin.GetCoinUseCase
import com.github.skytoph.currency.presentation.coin_details.mapper.CoinStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val communication: CoinStateCommunication,
    private val mapper: CoinStateMapper,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoin(coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            mapper.map(result).show(communication)
        }.launchIn(viewModelScope)
    }

    fun provideState() = communication.provide()
}