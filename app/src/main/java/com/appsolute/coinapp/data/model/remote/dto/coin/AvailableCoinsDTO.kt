package com.appsolute.coinapp.data.model.remote.dto.coin

data class AvailableCoinsDTO(
    val coins: List<CoinDTO>? = emptyList()
)