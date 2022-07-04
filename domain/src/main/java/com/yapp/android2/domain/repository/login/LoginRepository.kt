package com.yapp.android2.domain.repository.login

import com.yapp.android2.domain.entity.NotificationRequest
import com.yapp.android2.domain.entity.User
import com.yapp.android2.domain.repository.Repository

interface LoginRepository : Repository {

    suspend fun postLogin(
        email: String,
        nickName: String,
        providerId: Long
    ): User

    suspend fun postFCMToken(request: NotificationRequest)

    fun saveUser(user: User)

    fun getUser(): User
}
