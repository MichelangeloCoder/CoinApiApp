package com.example.coinapiapp.presentationlayer.coinlist

import com.example.coinapiapp.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coinList : List<Coin> = emptyList(),
    val error : String = ""
)
