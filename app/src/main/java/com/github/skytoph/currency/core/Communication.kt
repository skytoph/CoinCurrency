package com.github.skytoph.currency.core

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State

interface Communication {
    interface Provide<T> {
        fun provide(): State<T>
    }

    interface Show<T> {
        fun show(data: T)
    }

    interface Mutable<T> : Provide<T>, Show<T>

    abstract class Abstract<T>(protected val data: MutableState<T>) :
        Mutable<T> {

        override fun provide(): State<T> = data

        override fun show(data: T) {
            this.data.value = data
        }
    }
}