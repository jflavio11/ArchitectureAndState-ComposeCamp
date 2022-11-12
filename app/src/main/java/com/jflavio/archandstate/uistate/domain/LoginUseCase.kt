package com.jflavio.archandstate.uistate.domain

import com.jflavio.archandstate.uistate.data.AuthRepositoryImpl
import com.jflavio.archandstate.uistate.data.UserRepositoryImpl

/**
 * LoginUseCase
 *
 * @since 11/10/2022
 */
class LoginUseCase(
    private val userRepository: UserRepository = UserRepositoryImpl(),
    private val authRepository: AuthRepository = AuthRepositoryImpl()
) {

    suspend fun execute(userName: String, password: String): String {
        val loggedUserId = authRepository.login(userName, password)
        return userRepository.getUserCompleteName(loggedUserId)
    }
}