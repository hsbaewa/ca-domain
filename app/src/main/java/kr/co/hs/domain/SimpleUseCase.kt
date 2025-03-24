package kr.co.hs.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kr.co.hs.domain.entity.SimpleEntity

class SimpleUseCase : UseCase<String, SimpleEntity, SimpleUseCase.Error>() {
    sealed interface Error
    data object SimpleError

    override fun invoke(
        param: String
    ): Flow<Result<SimpleEntity, Error>> = flowOf(param)
        .map { SimpleEntity(it) }
        .onEach { it.isCachedData = true }
        .map { Result.Success(it) }
        .catch<Result<SimpleEntity, Error>> { emit(Result.Exception(it)) }
}