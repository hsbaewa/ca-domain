package kr.co.hs.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SimpleUseCase : UseCase<String, String, SimpleUseCase.Error>() {
    sealed interface Error
    data object SimpleError

    override fun invoke(
        param: String
    ): Flow<Result<String, Error>> = flowOf(param)
        .map { Result.Success(it) }
        .catch<Result<String, Error>> { emit(Result.Exception(it)) }
}