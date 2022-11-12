package com.jflavio.archandstate.uistate.data

import com.jflavio.archandstate.uistate.domain.AuthRepository

/**
 * AuthRepository
 *
 * @since 11/10/2022
 */
class AuthRepositoryImpl : AuthRepository {
    override suspend fun login(userName: String, password: String): String {
        return "id1"
    }
}