package com.github.skytoph.currency.core

sealed class ActionResult<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : ActionResult<T>(data)
    class Error<T>(message: String, data: T? = null) : ActionResult<T>(data, message)
    class Loading<T>(data: T? = null) : ActionResult<T>(data)
}