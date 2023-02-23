package com.github.skytoph.currency.presentation.coin_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.skytoph.currency.R
import com.github.skytoph.currency.data.remote.dto.TeamMember
import com.github.skytoph.currency.domain.model.CoinDetail
import com.github.skytoph.currency.presentation.ui.theme.CurrencyAppTheme
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun CoinDetails(
    coin: CoinDetail?,
    error: String = "",
    isLoading: Boolean = false,
) {
    Box(modifier = Modifier.fillMaxSize()) {
        coin?.let { coin ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(
                                R.string.coin_full_name, coin.rank, coin.name, coin.symbol
                            ),
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f)
                        )
                        Text(
                            text = if (coin.isActive) stringResource(R.string.active)
                            else stringResource(R.string.inactive),
                            color = if (coin.isActive) Color.Green else Color.Red,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = coin.description,
                        style = MaterialTheme.typography.body2
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.tags),
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    FlowRow(
                        mainAxisSpacing = 8.dp,
                        crossAxisSpacing = 8.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coin.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.team_members),
                        style = MaterialTheme.typography.h3
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                items(coin.team) { teamMember ->
                    TeamListItem(
                        teamMember = teamMember,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    )
                    Divider()
                }
            }
        }
        if (error.isNotBlank()) {
            Text(
                text = error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
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
        val team = listOf(
            TeamMember("id1", "member 1", "developer"),
            TeamMember("id2", "member 2", "designer")
        )
        val tags = listOf("tag", "mining", "third tag")
        val coin = CoinDetail(
            "BTC", "Bitcoin", "Bitcoin description", "BTC", 1, true,
            tags, team
        )
        CoinDetails(coin, "", false)
    }
}