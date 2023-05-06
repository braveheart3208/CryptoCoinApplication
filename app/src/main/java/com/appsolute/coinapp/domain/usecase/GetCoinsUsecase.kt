package com.appsolute.coinapp.domain.usecase

import com.appsolute.coinapp.application.core.Resource
import com.appsolute.coinapp.application.core.ResultInteractor
import com.appsolute.coinapp.application.core.UiText
import com.appsolute.coinapp.application.extension.Empty
import com.appsolute.coinapp.domain.model.Coin
import com.appsolute.coinapp.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by Toan (Alex) Duong.
 * This project StockMarketApp belongs to Appsolute.
 * Do Not Copy
 * Please Contact braveheart3208@gmail.com for more information
 */

class GetCoinsUsecase @Inject constructor(
    private val coinRepository: CoinRepository
) : ResultInteractor<Unit, Flow<Resource<List<Coin>>>>() {

    override val dispatcher: CoroutineDispatcher get() = Dispatchers.IO

    override suspend fun doWork(params: Unit): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.OnLoading())
        try {
            val coinList = coinRepository.getCoins()

            emit(Resource.OnSuccess(data = coinList))
        } catch (httpException: HttpException) {
            emit(Resource.OnError(message = UiText.DynamicString(httpException.message())))
        } catch (ioException: IOException) {
            emit(Resource.OnError(message = UiText.DynamicString(ioException.message ?: String.Empty)))
        }
    }

}