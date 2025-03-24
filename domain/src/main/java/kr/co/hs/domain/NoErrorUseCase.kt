package kr.co.hs.domain

import kotlinx.coroutines.flow.Flow

abstract class NoErrorUseCase<P, R> {
    abstract operator fun invoke(param: P): Flow<Result<R>>

    sealed class Result<out T> {
        data class Success<T>(val data: T) : Result<T>()
        data class Exception(val t: Throwable) : Result<Nothing>()

        fun getSuccessData() = (this as? Success)?.data
    }
}