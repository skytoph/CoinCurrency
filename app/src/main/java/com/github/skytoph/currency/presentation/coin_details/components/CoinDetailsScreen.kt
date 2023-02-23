package com.github.skytoph.currency.presentation.coin_details.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.skytoph.currency.presentation.coin_details.CoinDetailViewModel

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    CoinDetails(state.coin, state.error, state.isLoading)
}