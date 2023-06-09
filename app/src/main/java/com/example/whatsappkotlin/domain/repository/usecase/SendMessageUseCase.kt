package com.example.whatsappkotlin.domain.repository.usecase


import com.example.whatsappkotlin.data.remote.repository.Constants.DEFAULT_NETWORK_ERROR
import com.example.whatsappkotlin.domain.model.Message
import com.example.whatsappkotlin.domain.repository.MessagesRepository
import com.example.whatsappkotlin.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SendMessageUseCase @Inject constructor(
    private val repository: MessagesRepository,
) {
    suspend operator fun invoke(message: Message): Flow<Resource<Unit>> = flow {

        emit(Resource.Loading)

        val networkRequest = repository.sendMessage(message = message)

        when (networkRequest) {
            is Resource.Success -> emit(Resource.Success(Unit))
            is Resource.Error -> emit(Resource.Error(networkRequest.message))
            else -> emit(Resource.Error(DEFAULT_NETWORK_ERROR))
        }

    }
}