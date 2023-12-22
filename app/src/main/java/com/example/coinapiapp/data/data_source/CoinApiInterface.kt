/**
 * So here we have created a data package inside data package we have created a CoinApiInterface, and created our Api Endpoints
 * methods, and with help of suspended function we have called DTOModel packages in both the Api Endpoints.
 */
package com.example.coinapiapp.data.data_source

import com.example.coinapiapp.data.data_source.dtoModel.CoinDetailDTO.CoinDetailDTO
import com.example.coinapiapp.data.data_source.dtoModel.CoinListDTO.CoinListDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CoinApiInterface {

    @GET("/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page&sparkline=false")

    suspend fun getAllCoins(@Query("page")page:String):CoinListDTO

    @GET("/api/v3/coins/{id}")

    suspend fun getCoinById(@Path("id")id:String):CoinDetailDTO
}