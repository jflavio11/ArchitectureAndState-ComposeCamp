package com.jflavio.archandstate.uistate.domain

/**
 * AuthRepository
 *
 * @since 11/10/2022
 */
interface AuthRepository {
    suspend fun login(userName: String, password: String): String
}