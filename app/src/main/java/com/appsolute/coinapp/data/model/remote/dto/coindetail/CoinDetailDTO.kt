package com.appsolute.coinapp.data.model.remote.dto.coindetail

import com.appsolute.coinapp.application.extension.Empty

data class CoinDetailDTO(
    val description: String? = String.Empty,
    val development_status: String? = String.Empty,
    val first_data_at: String? = String.Empty,
    val hardware_wallet: Boolean? = false,
    val hash_algorithm: String? = String.Empty,
    val id: String? = String.Empty,
    val is_active: Boolean? = false,
    val is_new: Boolean? = false,
    val last_data_at: String? = String.Empty,
    val links: LinksDTO? = null,
    val links_extended: List<LinksExtendedDTO>? = emptyList(),
    val logo: String? = String.Empty,
    val message: String? = String.Empty,
    val name: String? = String.Empty,
    val open_source: Boolean? = false,
    val org_structure: String? = String.Empty,
    val proof_type: String? = String.Empty,
    val rank: Int? = 0,
    val started_at: String? = String.Empty,
    val symbol: String? = String.Empty,
    val tags: List<TagDTO>? = emptyList(),
    val team: List<TeamDTO>? = emptyList(),
    val type: String? = String.Empty,
    val whitepaper: WhitepaperDTO? = null
)