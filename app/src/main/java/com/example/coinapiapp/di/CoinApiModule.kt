/**
 * So basically we have created a di Package, inside di package we have created a object CoinApiModule, and initiated a
 * dagger hilt, we have created a two functions, provideCoinApiApp & provideCoinApiReposistory and called CoinApiInterface.
 */
package com.example.coinapiapp.di

import com.example.coinapiapp.data.data_source.CoinApiInterface
import com.example.coinapiapp.data.reposistory.CoinReposistoryImple
import com.example.coinapiapp.domain.reposistory.CoinReposistory
import com.example.coinapiapp.utilpackage.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoinApiModule {

    /**
     * created a function provideCoinApiApp, called CoinApiInterface and base url from constants
     */
    @Provides
    @Singleton
    fun provideCoinApiApp():CoinApiInterface{
        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinApiInterface::class.java)
    }

    /**
     * created a function provideCoinApiReposistory, called CoinReposistory and return CoinReposistoryImple api
     */

    @Provides
    @Singleton
    fun provideCoinApiReposistory(api:CoinApiInterface):CoinReposistory{

        return CoinReposistoryImple(api)
    }
}