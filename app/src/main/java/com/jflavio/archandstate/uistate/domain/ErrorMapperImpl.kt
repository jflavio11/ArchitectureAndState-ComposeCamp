package com.jflavio.archandstate.uistate.domain

/**
 * ErrorMapperImpl
 *
 * @since 11/23/2022
 */
data class ErrorInfo(
    val code: Int,
    val message: String
)

interface IErrorMapper {
    fun map(error: Throwable): ErrorInfo
}

class ErrorMapperImpl : IErrorMapper {
    override fun map(error: Throwable): ErrorInfo {
        return ErrorInfo(
            code = 400,
            message = error.message.orEmpty()
        )
    }
}