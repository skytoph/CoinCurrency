package com.github.skytoph.currency.presentation.coin_list.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.skytoph.currency.presentation.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
) {
    val state = viewModel.provideState()
    CoinList(
        coins = state.value.coins,
        error = state.value.error,
        isLoading = state.value.isLoading,
        navController
    )
}