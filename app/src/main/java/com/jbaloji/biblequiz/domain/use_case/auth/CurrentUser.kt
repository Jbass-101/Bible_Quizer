package com.jbaloji.biblequiz.domain.use_case.auth

import com.jbaloji.biblequiz.domain.repository.AuthRepository

class CurrentUser(private val repo: AuthRepository) {

     fun get() = repo.currentUser

}