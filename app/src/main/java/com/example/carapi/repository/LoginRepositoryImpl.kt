package com.example.carapi.repository

import com.example.carapi.util.Resource
import com.example.carapi.util.await
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginRepositoryImpl(private val firebaseAuth: FirebaseAuth) : LoginRepository {
    override val currentUser: FirebaseUser?
        get() = firebaseAuth.currentUser

    override suspend fun login(email: String, password: String): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

    override suspend fun register(
        email: String,
        name: String,
        password: String
    ): Resource<FirebaseUser> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Resource.Success(result.user!!)
        } catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message.toString())
        }
    }

    override fun logout() {
        TODO("Not yet implemented")
    }
}