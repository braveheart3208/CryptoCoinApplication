package com.appsolute.coinapp.presentation.coinlist.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolute.coinapp.application.core.Resource
import com.appsolute.coinapp.domain.model.SortingType
import com.appsolute.coinapp.domain.usecase.GetCoinsUsecase
import com.appsolute.coinapp.domain.usecase.SortCoinsUsecase
import com.appsolute.coinapp.presentation.coinlist.event.CoinListEvent
import com.appsolute.coinapp.presentation.coinlist.state.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */
@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUsecase: GetCoinsUsecase,
    private val sortCoinsUsecase : SortCoinsUsecase
) : ViewModel() {
    private val _coinListState = mutableStateOf(CoinListState())
    val coinListState: State<CoinListState> = _coinListState

    private var getCoinsJob: Job? = null

    init {
        getCoins()
    }

    fun onEventCalled(event: CoinListEvent) {
        when (event) {
            is CoinListEvent.OnSortingOptionSelected -> {
                _coinListState.value = coinListState.value.copy(sortingType = SortingType.fromString(event.sortingOption))

                sortCoinList()
            }

            else -> Unit
        }
    }

    private fun getCoins() {
        getCoinsJob?.cancel()
        getCoinsJob = viewModelScope.launch {
            getCoinsUsecase(Unit).collect { result ->
                when (result) {
                    is Resource.OnLoading -> {
                        _coinListState.value = coinListState.value.copy(isLoading = true)
                    }

                    is Resource.OnError -> {
                        _coinListState.value =
                            coinListState.value.copy(isLoading = false, error = result.message)
                    }

                    is Resource.OnSuccess -> {
                        _coinListState.value =
                            coinListState.value.copy(isLoading = false, coins = result.data!!)
                        sortCoinList()
                    }
                }
            }
        }
    }

    private fun sortCoinList(){
        if(_coinListState.value.sortingType == SortingType.SortDescending){
            _coinListState.value = coinListState.value.copy(
                coins = sortCoinsUsecase.sortCoinsDescending(coinListState.value.coins)
            )
        }else if(_coinListState.value.sortingType == SortingType.SortAscending){
            _coinListState.value = coinListState.value.copy(
                coins = sortCoinsUsecase.sortCoinsAscending(coinListState.value.coins)
            )
        }
    }
}