package com.appsolute.coinapp.data.model.remote

import com.appsolute.coinapp.data.model.remote.dto.coin.AvailableCoinsDTO
import com.appsolute.coinapp.data.model.remote.dto.coin.CoinDTO
import com.appsolute.coinapp.data.model.remote.dto.coindetail.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */
interface CoinApi {
    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDTO?
}