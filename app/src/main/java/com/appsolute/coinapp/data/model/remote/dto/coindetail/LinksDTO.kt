package com.appsolute.coinapp.data.model.remote.dto.coindetail

data class LinksDTO(
    val explorer: List<String>? = emptyList(),
    val facebook: List<String>? = emptyList(),
    val reddit: List<String>? = emptyList(),
    val source_code: List<String>? = emptyList(),
    val website: List<String>? = emptyList(),
    val youtube: List<String>? = emptyList()
)