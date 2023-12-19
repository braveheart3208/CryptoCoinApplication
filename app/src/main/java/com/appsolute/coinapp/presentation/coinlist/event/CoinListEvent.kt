package com.appsolute.coinapp.presentation.coinlist.event

import com.appsolute.coinapp.domain.model.Coin

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

sealed class CoinListEvent{
    class OnCoinSelected(coin : Coin) : CoinListEvent()

    class OnSortingOptionSelected(val sortingOption : String) : CoinListEvent()
}
