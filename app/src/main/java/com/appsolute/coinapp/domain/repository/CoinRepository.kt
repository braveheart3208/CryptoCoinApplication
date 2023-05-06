package com.appsolute.coinapp.domain.repository

import com.appsolute.coinapp.domain.model.Coin
import com.appsolute.coinapp.domain.model.CoinDetail

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */
interface CoinRepository {
    suspend fun getCoins(): List<Coin>

    suspend fun getCoinDetail(coinId: String): CoinDetail?
}