package com.appsolute.coinapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appsolute.coinapp.application.core.Screen
import com.appsolute.coinapp.presentation.coindetail.components.CoinDetailScreen
import com.appsolute.coinapp.presentation.coindetail.viewmodel.CoinDetailViewModel
import com.appsolute.coinapp.presentation.coinlist.components.CoinListScreen
import com.appsolute.coinapp.presentation.coinlist.viewmodel.CoinListViewModel
import com.appsolute.coinapp.presentation.ui.theme.StockMarketAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockMarketAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(route = Screen.CoinListScreen.route) {
                            val viewModel = hiltViewModel<CoinListViewModel>()
                            CoinListScreen(
                                state = viewModel.coinListState.value,
                                onEvent = viewModel::onEventCalled,
                                navigationController = navController
                            )
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                            val viewModel = hiltViewModel<CoinDetailViewModel>()
                            CoinDetailScreen(state = viewModel.coinDetailState.value)
                        }
                    }
                }
            }
        }
    }
}