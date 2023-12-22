package com.example.coinapiapp.domain.use_cases

import com.example.coinapiapp.domain.model.Coin
import com.example.coinapiapp.domain.model.CoinDetail
import com.example.coinapiapp.domain.reposistory.CoinReposistory
import com.example.coinapiapp.utilpackage.ResponseState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinDetailUseCase @Inject constructor(
    private val repository: CoinReposistory
) {

    operator fun invoke(id: String): Flow<ResponseState<CoinDetail>> = flow {

        try {
            emit(ResponseState.Loading<CoinDetail>())
            val coinDetail = repository.getCoinById(id).toCoinDetail()
            emit(ResponseState.Success<CoinDetail>(coinDetail))

        }
        catch (e: HttpException){
            emit(ResponseState.Error<CoinDetail>(e.localizedMessage?:"An Unexpected Api Error Occurred"))
        }
        catch (e: IOException){
            emit(ResponseState.Error<CoinDetail>("Error Occurred"))

        }
    }
}