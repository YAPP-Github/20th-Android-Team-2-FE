package com.yapp.android2.domain.usecase

import com.yapp.android2.domain.UseCase
import com.yapp.android2.domain.entity.Login
import com.yapp.android2.domain.entity.base.ApiResponse
import com.yapp.android2.domain.repository.login.LoginRepository
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val loginRepository: LoginRepository
) : LoginUseCase {

    override suspend fun execute(params: LoginUseCase.Params): ApiResponse<String> {
        return loginRepository.login(params.loginType)
    }

}

interface LoginUseCase : UseCase<LoginUseCase.Params, ApiResponse<String>> {
    data class Params(val loginType: Login.Type)
}
