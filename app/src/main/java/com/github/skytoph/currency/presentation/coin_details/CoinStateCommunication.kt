package com.github.skytoph.currency.presentation.coin_details

import androidx.compose.runtime.mutableStateOf
import com.github.skytoph.currency.core.Communication
import javax.inject.Inject

interface CoinStateCommunication : Communication.Mutable<CoinDetailState> {

    class Base @Inject constructor() :
        Communication.Abstract<CoinDetailState>(mutableStateOf(CoinDetailState())),
        CoinStateCommunication
}