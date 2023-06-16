package com.example.whatsappkotlin.domain.repository

interface UserRepository {

    fun saveUserId (userId :String)
    fun getUserId(): String
}