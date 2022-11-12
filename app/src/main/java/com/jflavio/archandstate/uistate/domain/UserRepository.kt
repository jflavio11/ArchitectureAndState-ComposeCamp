package com.jflavio.archandstate.uistate.domain

/**
 * UserRepository
 *
 * @since 11/10/2022
 */
interface UserRepository {
    suspend fun getUserCompleteName(id: String): String
}