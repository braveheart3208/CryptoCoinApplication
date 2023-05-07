package com.appsolute.coinapp.presentation.coindetail.state

import com.appsolute.coinapp.application.core.UiText
import com.appsolute.coinapp.domain.model.CoinDetail

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

data class CoinDetailState(
    val coin: CoinDetail? = null,
    val isLoading: Boolean = false,
    val error: UiText? = null
)
