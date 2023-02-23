package com.github.skytoph.currency.presentation

sealed class Screen(val route: String) {

    object CoinListScreen : Screen("coin_list")

    class CoinDetailScreen(val coinId: String) : Screen("coin_detail/${coinId}") {

        companion object {
            const val baseRoute = "coin_detail/{coinId}"
        }
    }
}