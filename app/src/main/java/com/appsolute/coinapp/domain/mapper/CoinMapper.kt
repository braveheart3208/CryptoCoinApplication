package com.appsolute.coinapp.domain.mapper

import com.appsolute.coinapp.data.model.remote.dto.coin.CoinDTO
import com.appsolute.coinapp.data.model.remote.dto.coindetail.CoinDetailDTO
import com.appsolute.coinapp.domain.model.Coin
import com.appsolute.coinapp.domain.model.CoinDetail
import com.appsolute.coinapp.domain.model.TeamMember

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

fun CoinDTO.toCoinDetail(): Coin {
    return Coin(
        id = this.id!!,
        isActive = this.is_active!!,
        name = this.name!!,
        rank = this.rank!!,
        symbol = this.symbol!!
    )
}

fun CoinDetailDTO.toCoinDetail(): CoinDetail {
    return CoinDetail(
        name = this.name!!,
        description = this.description!!,
        id = this.id!!,
        isActive = this.is_active!!,
        symbol = this.symbol!!,
        tags = this.tags?.map { it.name!! } ?: emptyList(),
        members = this.team?.map {
            TeamMember(
                id = it.id!!,
                name = it.name!!,
                position = it.position!!
            )
        } ?: emptyList()
    )
}