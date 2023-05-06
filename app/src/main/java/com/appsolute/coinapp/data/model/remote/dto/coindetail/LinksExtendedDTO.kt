package com.appsolute.coinapp.data.model.remote.dto.coindetail

import com.appsolute.coinapp.application.extension.Empty

data class LinksExtendedDTO(
    val stats: StatsDTO? = null,
    val type: String? = String.Empty,
    val url: String? = String.Empty
)