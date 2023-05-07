package com.appsolute.coinapp.presentation.coinlist.state

import com.appsolute.coinapp.application.core.UiText
import com.appsolute.coinapp.domain.model.Coin

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: UiText? = null
)