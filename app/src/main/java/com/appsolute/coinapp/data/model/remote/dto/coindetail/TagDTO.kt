package com.appsolute.coinapp.data.model.remote.dto.coindetail

import com.appsolute.coinapp.application.extension.Empty

data class TagDTO(
    val coin_counter: Int? = 0,
    val ico_counter: Int? = 0,
    val id: String? = String.Empty,
    val name: String? = String.Empty
)