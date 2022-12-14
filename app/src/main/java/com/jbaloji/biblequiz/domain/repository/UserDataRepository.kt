package com.jbaloji.biblequiz.domain.repository

import com.jbaloji.biblequiz.domain.model.Response
import com.jbaloji.biblequiz.domain.model.UserData
import kotlinx.coroutines.flow.Flow

typealias UserDataResponse = Response<UserData>

interface UserDataRepository {

    fun writeUserData(
        user: String,
        gameType: String,
        docName: String
    ): Flow<UserDataResponse>

    fun getUserData(
        user: String,
        gameType: String,
        docName: String
    ): Flow<UserDataResponse>

    fun updateUserdata(
        user: String,
        gameType: String,
        docName: String,
        fieldName: String,
        updateVal: Int
    ): Flow<Response<Boolean>>


}