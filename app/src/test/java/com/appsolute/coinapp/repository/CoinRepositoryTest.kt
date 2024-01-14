package com.appsolute.coinapp.repository

import com.appsolute.coinapp.data.model.remote.CoinApi
import com.appsolute.coinapp.data.model.remote.dto.coin.CoinDTO
import com.appsolute.coinapp.data.model.remote.dto.coindetail.CoinDetailDTO
import com.appsolute.coinapp.data.repository.CoinRepoImpl
import com.appsolute.coinapp.domain.repository.CoinRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

/**
 * @author : alexyang - Appsolute
 * @mailto : braveheart3208@mail.com
 * @created : 19/12/2023, Tuesday
 **/
class CoinRepositoryTest {

    @Mock
    private lateinit var coinApiService: CoinApi

    private lateinit var coinRepo: CoinRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        coinRepo = CoinRepoImpl(coinApi = coinApiService)
    }

    @Test
    fun `test getCoins() returns same mock list from API`() {
        runBlocking {
            val mockCoinList = CoinDTO.mock()
            `when`(coinApiService.getCoins()).thenReturn(mockCoinList)

            val returnedCoinList = coinRepo.getCoins()

            assert(mockCoinList.size == returnedCoinList.size)
        }
    }

    @Test
    fun `test getCoinDetail() returns same Coin ID from API`() {
        runBlocking {
            val coinId = "MockId"
            `when`(coinApiService.getCoinById(coinId)).thenReturn(
                CoinDetailDTO(
                    id = "MockId",
                    description = null,
                    development_status = null,
                    first_data_at = null,
                    hardware_wallet = null,
                    hash_algorithm = null,
                    is_active = null,
                    is_new = null,
                    last_data_at = null,
                    links = null,
                    links_extended = listOf(),
                    logo = null,
                    message = null,
                    name = null,
                    open_source = null,
                    org_structure = null,
                    proof_type = null,
                    rank = null,
                    started_at = null,
                    symbol = null,
                    tags = listOf(),
                    team = listOf(),
                    type = null,
                    whitepaper = null
                )
            )

            val returnedCoinDetail = coinRepo.getCoinDetail(coinId)

            assert(returnedCoinDetail != null)
            assert(returnedCoinDetail!!.id == coinId)
        }
    }
}