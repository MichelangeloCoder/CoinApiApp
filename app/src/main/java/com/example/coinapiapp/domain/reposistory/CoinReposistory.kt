/**
 * So in domain package we have created three packages model,repo,use_cases,in repository we have created interface
 * CoinReposistory, implemented two suspended functions and called dtoModel package i.e CoinListDTO, CoinDetailDTO.
 */
package com.example.coinapiapp.domain.reposistory

import com.example.coinapiapp.data.data_source.dtoModel.CoinDetailDTO.CoinDetailDTO
import com.example.coinapiapp.data.data_source.dtoModel.CoinListDTO.CoinListDTO

interface CoinReposistory {

    suspend fun getAllCoins(page:String):CoinListDTO

    suspend fun getCoinById(id:String):CoinDetailDTO
}