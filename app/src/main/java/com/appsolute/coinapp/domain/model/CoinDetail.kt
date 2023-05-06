package com.appsolute.coinapp.domain.model

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */
data class CoinDetail(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val symbol: String,
    val tags: List<String>
)
