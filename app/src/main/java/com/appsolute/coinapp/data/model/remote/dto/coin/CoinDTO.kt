package com.appsolute.coinapp.data.model.remote.dto.coin

import com.appsolute.coinapp.application.extension.Empty

data class CoinDTO(
    val id: String? = String.Empty,
    val is_active: Boolean? = false,
    val is_new: Boolean? = false,
    val name: String? = String.Empty,
    val rank: Int? = 0,
    val symbol: String? = String.Empty,
    val type: String? = String.Empty
)