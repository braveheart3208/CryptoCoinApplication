package com.appsolute.coinapp.api

import com.appsolute.coinapp.data.model.remote.CoinApi
import com.appsolute.coinapp.data.model.remote.dto.coin.CoinDTO
import com.google.gson.GsonBuilder
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 19/12/2023, Tuesday
 **/
class CoinApiTest {

    @Mock
    private lateinit var coinApiService: CoinApi

    @Before
    fun setup() {
    }

    @After
    fun tearDown(){
    }

    @Test
    fun `test getCoins() success`() {

    }
}