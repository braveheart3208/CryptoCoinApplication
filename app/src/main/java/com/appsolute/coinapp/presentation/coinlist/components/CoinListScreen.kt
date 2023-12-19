package com.appsolute.coinapp.presentation.coinlist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.appsolute.coinapp.R
import com.appsolute.coinapp.application.core.Screen
import com.appsolute.coinapp.presentation.coinlist.event.CoinListEvent
import com.appsolute.coinapp.presentation.coinlist.state.CoinListState
import com.appsolute.coinapp.presentation.components.fab_with_sub_items.FabState
import com.appsolute.coinapp.presentation.components.fab_with_sub_items.FabWithSubItems
import com.appsolute.coinapp.presentation.components.fab_with_sub_items.SubItem
import com.appsolute.coinapp.presentation.ui.theme.LocalSpacing

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinListScreen(
    state: CoinListState,
    onEvent: (CoinListEvent) -> Unit,
    navigationController: NavController
) {

    val spacing = LocalSpacing.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FabWithSubItems(
                initialState = FabState.Collapsed,
                subItems = listOf(
                    SubItem(
                        "SortUp",
                        ImageBitmap.imageResource(R.drawable.ic_sort_up_64px),
                        "Sort Ascending"
                    ),
                    SubItem(
                        "SortDown",
                        ImageBitmap.imageResource(R.drawable.ic_sort_down_64px),
                        "Sort Descending"
                    )
                ),
                onSubItemClicked = {
                    onEvent(CoinListEvent.OnSortingOptionSelected(it.id))
                }
            )
        }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                item {
                    Text(
                        text = "Coin List",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.headlineLarge,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = spacing.spaceM)
                            .align(Alignment.Center)
                    )
                }
                items(state.coins) { coin ->
                    CoinItem(
                        coin = coin,
                        onItemClick = {
                            navigationController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                        }
                    )
                }
            }
            if (state.error != null) {
                Text(
                    text = state.error.asString(),
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}