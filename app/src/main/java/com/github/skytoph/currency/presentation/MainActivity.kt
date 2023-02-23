package com.github.skytoph.currency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.skytoph.currency.presentation.coin_details.components.CoinDetailScreen
import com.github.skytoph.currency.presentation.coin_list.components.CoinListScreen
import com.github.skytoph.currency.presentation.ui.theme.CurrencyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(route = Screen.CoinDetailScreen.baseRoute) {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}