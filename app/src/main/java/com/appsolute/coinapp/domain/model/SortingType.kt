package com.appsolute.coinapp.domain.model

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 19/12/2023, Tuesday
 **/
sealed class SortingType {
    object SortAscending : SortingType()
    object SortDescending : SortingType()

    companion object {
        fun fromString(sortingId: String): SortingType {
            return when (sortingId) {
                "SortUp" -> SortAscending
                else -> SortDescending
            }
        }
    }
}