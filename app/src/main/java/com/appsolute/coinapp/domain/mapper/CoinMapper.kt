package com.appsolute.coinapp.domain.mapper

import com.appsolute.coinapp.application.extension.Empty
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

fun CoinDTO.toCoin(): Coin {
    return Coin(
        id = this.id ?: String.Empty,
        isActive = this.is_active ?: false,
        name = this.name ?: String.Empty,
        rank = this.rank ?: 0,
        symbol = this.symbol ?: String.Empty
    )
}

fun CoinDetailDTO.toCoin(): CoinDetail {
    return CoinDetail(
        name = this.name ?: String.Empty,
        description = this.description ?: String.Empty,
        id = this.id ?: String.Empty,
        isActive = this.is_active ?: false,
        symbol = this.symbol ?: String.Empty,
        tags = this.tags?.map { it.name ?: String.Empty } ?: emptyList(),
        members = this.team?.map {
            TeamMember(
                id = it.id ?: String.Empty,
                name = it.name ?: String.Empty,
                position = it.position ?: String.Empty
            )
        } ?: emptyList()
    )
}