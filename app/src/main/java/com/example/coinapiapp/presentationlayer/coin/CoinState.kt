package com.example.coinapiapp.presentationlayer.coin

import com.example.coinapiapp.domain.model.Coin
import com.example.coinapiapp.domain.model.CoinDetail

data class CoinState(
    val isLoading : Boolean = false,
    val coinDetail: CoinDetail?=null,
    val error : String = ""
)
