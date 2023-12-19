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
){
    fun mock() : List<CoinDTO> {
        return listOf(
            CoinDTO(
                id = "123",
                is_active = true,
                is_new = false,
                name = "Mock Coin 1",
                rank = 69,
                symbol = "$$",
                type = ""
            ),
            CoinDTO(
                id = "123321",
                is_active = true,
                is_new = false,
                name = "Mock Coin 2",
                rank = 96,
                symbol = "&&",
                type = ""
            ),
            CoinDTO(
                id = "123456",
                is_active = true,
                is_new = false,
                name = "Mock Coin 3",
                rank = 6,
                symbol = "%%",
                type = ""
            )
        )
    }
}