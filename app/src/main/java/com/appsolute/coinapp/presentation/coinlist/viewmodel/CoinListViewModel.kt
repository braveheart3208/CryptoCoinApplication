package com.appsolute.coinapp.presentation.coinlist.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolute.coinapp.application.core.Resource
import com.appsolute.coinapp.domain.usecase.GetCoinsUsecase
import com.appsolute.coinapp.presentation.coinlist.event.CoinListEvent
import com.appsolute.coinapp.presentation.coinlist.state.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.onEach
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
    private val getCoinsUsecase: GetCoinsUsecase
) : ViewModel() {
    private val _coinListState = mutableStateOf(CoinListState())
    val coinListState: State<CoinListState> = _coinListState

    private var getCoinsJob: Job? = null

    init {
        getCoins()
    }

    fun onEventCalled(event: CoinListEvent) {

    }

    private fun getCoins() {
        getCoinsJob?.cancel()
        getCoinsJob = viewModelScope.launch {
            getCoinsUsecase(Unit).onEach { result ->
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
                    }
                }
            }
        }
    }
}