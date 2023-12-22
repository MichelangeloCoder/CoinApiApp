/**
 * So here in data package, we have created repository package, and implemented class CoinReposistoryImple, we have
 * inject dagger hilt, and called CoinApiInterface, CoinReposistory, and implemented two suspended functions and called
 * CoinListDTO & CoinDetailDTO
 */
package com.example.coinapiapp.data.reposistory

import com.example.coinapiapp.data.data_source.CoinApiInterface
import com.example.coinapiapp.data.data_source.dtoModel.CoinDetailDTO.CoinDetailDTO
import com.example.coinapiapp.data.data_source.dtoModel.CoinListDTO.CoinListDTO
import com.example.coinapiapp.domain.reposistory.CoinReposistory
import javax.inject.Inject

class CoinReposistoryImple @Inject constructor(
    private val coinApi : CoinApiInterface
) : CoinReposistory {
    override suspend fun getAllCoins(page: String): CoinListDTO {
        return coinApi.getAllCoins(page=page)
    }

    override suspend fun getCoinById(id: String): CoinDetailDTO {
        return coinApi.getCoinById(id = id)
    }
}