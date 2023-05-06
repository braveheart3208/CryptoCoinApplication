package com.appsolute.coinapp.domain.usecase

import com.appsolute.coinapp.application.core.Resource
import com.appsolute.coinapp.application.core.ResultInteractor
import com.appsolute.coinapp.application.core.UiText
import com.appsolute.coinapp.application.extension.Empty
import com.appsolute.coinapp.domain.model.Coin
import com.appsolute.coinapp.domain.model.CoinDetail
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

class GetCoinByIdUsecase @Inject constructor(
    private val coinRepository: CoinRepository
) : ResultInteractor<String, Flow<Resource<CoinDetail>>>() {

    override val dispatcher: CoroutineDispatcher get() = Dispatchers.IO

    override suspend fun doWork(params: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.OnLoading())
        try {
            val coinDetail = coinRepository.getCoinDetail(params)

            coinDetail?.let {
                emit(Resource.OnSuccess(data = it))
            }?: emit(Resource.OnError(message = UiText.DynamicString("Coin not found!")))
        } catch (httpException: HttpException) {
            emit(Resource.OnError(message = UiText.DynamicString(httpException.message())))
        } catch (ioException: IOException) {
            emit(Resource.OnError(message = UiText.DynamicString(ioException.message ?: String.Empty)))
        }
    }

}