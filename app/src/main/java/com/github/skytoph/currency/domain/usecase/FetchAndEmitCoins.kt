package com.github.skytoph.currency.domain.usecase

import com.github.skytoph.currency.core.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

abstract class FetchAndEmitCoins<T> {

    operator fun invoke(coinId: String = ""): Flow<Result<T>> = flow {
        try {
            emit(Result.Loading())
            val coin = fetch(coinId)
            emit(Result.Success(coin))
        } catch (e: HttpException) {
            emit(Result.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Result.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    protected abstract suspend fun fetch(coinId: String = ""): T
}