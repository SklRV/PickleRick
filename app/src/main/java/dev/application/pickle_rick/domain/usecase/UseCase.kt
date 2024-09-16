package dev.application.pickle_rick.domain.usecase

import dev.application.pickle_rick.common.client_result.ClientResult

abstract class UseCase<Input, Output> {
    abstract suspend fun call(param: Input): ClientResult<Output>
}
