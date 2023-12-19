package com.appsolute.coinapp.presentation.coinlist.state

import com.appsolute.coinapp.application.core.UiText
import com.appsolute.coinapp.domain.model.Coin
import com.appsolute.coinapp.domain.model.SortingType

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val sortingType: SortingType = SortingType.SortDescending,
    val error: UiText? = null
)