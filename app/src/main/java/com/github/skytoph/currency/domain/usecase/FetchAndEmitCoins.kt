package com.github.skytoph.currency.domain.usecase

import com.github.skytoph.currency.core.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

abstract class FetchAndEmitCoins<T> {

    operator fun invoke(coinId: String = ""): Flow<Resource<T>> = flow {
        try {
            emit(Resource.Loading())
            val coin = fetch(coinId)
            emit(Resource.Success(coin))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    protected abstract suspend fun fetch(coinId: String = ""): T
}