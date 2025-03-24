package kr.co.hs.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SimpleNoErrorUseCase : NoErrorUseCase<String, String>() {

    override fun invoke(
        param: String
    ): Flow<Result<String>> = flowOf(param)
        .map { Result.Success(it) }
        .catch<Result<String>> { emit(Result.Exception(it)) }
}