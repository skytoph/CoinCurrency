package com.github.skytoph.currency.presentation.coin_list

import androidx.compose.runtime.mutableStateOf
import com.github.skytoph.currency.core.Communication
import javax.inject.Inject

interface CoinListStateCommunication : Communication.Mutable<CoinListState> {

    class Base @Inject constructor() :
        Communication.Abstract<CoinListState>(mutableStateOf(CoinListState())),
        CoinListStateCommunication
}