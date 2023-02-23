package com.github.skytoph.currency.presentation.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.github.skytoph.currency.domain.model.Coin
import com.github.skytoph.currency.presentation.Screen
import com.github.skytoph.currency.presentation.ui.theme.CurrencyAppTheme

@Composable
fun CoinList(
    coins: List<Coin>,
    error: String,
    isLoading: Boolean,
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(coins) { coin ->
                CoinListItem(coin = coin, onItemClick = {
                    navController.navigate(Screen.CoinDetailScreen(coin.id).route)
                })
            }
        }
        if (error.isNotBlank()) {
            Text(
                text = error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .align(Alignment.Center)
            )
        }
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CurrencyAppTheme {
        val coins = listOf(Coin("BTC", true, "Bitcoin", 1, "BTC"))
        CoinList(coins, "", false, rememberNavController())
    }
}