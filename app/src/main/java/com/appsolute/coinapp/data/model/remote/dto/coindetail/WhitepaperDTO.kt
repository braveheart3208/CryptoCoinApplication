package com.appsolute.coinapp.data.model.remote.dto.coindetail

import com.appsolute.coinapp.application.extension.Empty

data class WhitepaperDTO(
    val link: String? = String.Empty,
    val thumbnail: String? = String.Empty
)