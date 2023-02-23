package com.github.skytoph.currency.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.skytoph.currency.core.ActionResult
import com.github.skytoph.currency.domain.model.Coin
import com.github.skytoph.currency.domain.usecase.get_coins.GetCoinsUseCase
import com.github.skytoph.currency.presentation.coin_list.mapper.CoinListStateMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val communication: CoinListStateCommunication,
    private val mapper: CoinListStateMapper
) : ViewModel() {

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result: ActionResult<List<Coin>> ->
            mapper.map(result).show(communication)
        }.launchIn(viewModelScope)
    }

    fun provideState() = communication.provide()
}