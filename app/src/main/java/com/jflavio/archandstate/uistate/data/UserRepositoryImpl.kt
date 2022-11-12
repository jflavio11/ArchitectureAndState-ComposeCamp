package com.jflavio.archandstate.uistate.data

import com.jflavio.archandstate.uistate.domain.UserRepository

/**
 * UserRepositoryImpl
 *
 * @since 11/10/2022
 */
class UserRepositoryImpl : UserRepository {
    override suspend fun getUserCompleteName(id: String): String {
        return "Jose Flavio"
    }
}