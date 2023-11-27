package com.loc.newsapp.data.repository


import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.loc.newsapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun loginUser(email: String, password: String): Flow<Resource<AuthResult>>
    fun registerUser(email: String, password: String): Flow<Resource<AuthResult>>

    fun googleSignIn(credential: AuthCredential): Flow<Resource<AuthResult>>
}