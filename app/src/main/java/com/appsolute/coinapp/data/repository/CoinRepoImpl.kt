package com.appsolute.coinapp.data.repository

import com.appsolute.coinapp.data.model.remote.CoinApi
import com.appsolute.coinapp.domain.mapper.toCoinDetail
import com.appsolute.coinapp.domain.model.Coin
import com.appsolute.coinapp.domain.model.CoinDetail
import com.appsolute.coinapp.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

class CoinRepoImpl @Inject constructor(
    private val coinApi: CoinApi
) : CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return coinApi.getCoins()?.coins!!.map { it.toCoinDetail() }
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetail? {
        return coinApi.getCoinById(coinId)?.toCoinDetail()
    }
}