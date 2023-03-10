package com.github.skytoph.currency.domain.usecase

import com.github.skytoph.currency.core.ActionResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

abstract class FetchAndEmitCoins<T> {

    operator fun invoke(coinId: String = ""): Flow<ActionResult<T>> = flow {
        try {
            emit(ActionResult.Loading())
            val coin = fetch(coinId)
            emit(ActionResult.Success(coin))
        } catch (e: HttpException) {
            emit(ActionResult.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(ActionResult.Error("Couldn't reach server. Check your internet connection"))
        }
    }

    protected abstract suspend fun fetch(coinId: String = ""): T
}