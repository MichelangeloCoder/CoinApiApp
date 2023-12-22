package com.example.coinapiapp.domain.use_cases

import com.example.coinapiapp.domain.model.Coin
import com.example.coinapiapp.domain.reposistory.CoinReposistory
import com.example.coinapiapp.utilpackage.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinListUseCase @Inject constructor(
    private val repository : CoinReposistory
) {
    operator fun invoke(page: String): Flow<ResponseState<List<Coin>>> = flow {

        try {
            emit(ResponseState.Loading<List<Coin>>())
            val coins = repository.getAllCoins(page).map {
                it.toCoin()
            }
            emit(ResponseState.Success<List<Coin>>(coins))

        }
        catch (e:HttpException){
            emit(ResponseState.Error<List<Coin>>(e.localizedMessage?:"An Unexpected Api Error Occurred"))
        }
        catch (e:IOException){
            emit(ResponseState.Error<List<Coin>>("Error Occurred"))

        }
    }
}