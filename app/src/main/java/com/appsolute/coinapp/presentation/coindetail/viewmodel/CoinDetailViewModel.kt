package com.appsolute.coinapp.presentation.coindetail.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsolute.coinapp.application.core.Resource
import com.appsolute.coinapp.domain.usecase.GetCoinByIdUsecase
import com.appsolute.coinapp.presentation.coindetail.event.CoinDetailScreenEvent
import com.appsolute.coinapp.presentation.coindetail.state.CoinDetailState
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
class CoinDetailViewModel @Inject constructor(
    private val getCoinByIdUsecase: GetCoinByIdUsecase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _coinDetailState = mutableStateOf(CoinDetailState())
    val coinDetailState: State<CoinDetailState> = _coinDetailState

    var getCoinDetailJob: Job? = null

    init {
        savedStateHandle.get<String>("coinId")?.let { coinId ->
            getCoinDetail(coinId)
        }
    }

    fun onEventCalled(event: CoinDetailScreenEvent) {

    }

    private fun getCoinDetail(coinId: String) {
        getCoinDetailJob?.cancel()
        getCoinDetailJob = viewModelScope.launch {
            getCoinByIdUsecase(coinId).collect { result ->
                when (result) {
                    is Resource.OnError -> {
                        _coinDetailState.value =
                            coinDetailState.value.copy(isLoading = false, error = result.message)
                    }

                    is Resource.OnLoading -> {
                        _coinDetailState.value =
                            coinDetailState.value.copy(isLoading = true)
                    }

                    is Resource.OnSuccess -> {
                        _coinDetailState.value =
                            coinDetailState.value.copy(isLoading = false, coin = result.data)
                    }
                }
            }
        }
    }

}