package com.appsolute.coinapp.data.model.remote.dto.coindetail

import com.appsolute.coinapp.application.extension.Empty

data class TeamDTO(
    val id: String? = String.Empty,
    val name: String? = String.Empty,
    val position: String? = String.Empty
)