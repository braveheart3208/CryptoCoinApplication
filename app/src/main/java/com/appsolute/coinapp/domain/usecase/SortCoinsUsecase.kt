package com.appsolute.coinapp.domain.usecase

import com.appsolute.coinapp.domain.model.Coin
import javax.inject.Inject

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 19/12/2023, Tuesday
 **/
class SortCoinsUsecase @Inject constructor(
    val sortCoinsAscending: SortCoinsAscendingUsecase,
    val sortCoinsDescending: SortCoinsDescendingUsecase
)

class SortCoinsAscendingUsecase @Inject constructor() {
    operator fun invoke(coinList: List<Coin>): List<Coin> {
        return coinList.sortedBy {
            it.rank
        }
    }
}

class SortCoinsDescendingUsecase @Inject constructor() {
    operator fun invoke(coinList: List<Coin>): List<Coin> {
        return coinList.sortedByDescending {
            it.rank
        }
    }
}