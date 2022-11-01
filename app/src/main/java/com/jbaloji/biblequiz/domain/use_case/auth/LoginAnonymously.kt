package com.jbaloji.biblequiz.domain.use_case.auth

import com.jbaloji.biblequiz.domain.repository.AuthRepository

class LoginAnonymously (private val repo: AuthRepository) {

    operator fun invoke() = repo.loginAnonymously()
}