package com.example.whatsappkotlin.di


import com.example.whatsappkotlin.data.local.repository.UserRepositoryImpl
import com.example.whatsappkotlin.data.remote.repository.MessagesRepositoryImpl
import com.example.whatsappkotlin.domain.repository.MessagesRepository
import com.example.whatsappkotlin.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMessagesRepository(
        messagesRepository: MessagesRepositoryImpl
    ): MessagesRepository

    @Binds
    abstract fun bindUserRepository(userRepository:UserRepositoryImpl):UserRepository

}