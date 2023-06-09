package com.example.whatsappkotlin.domain.repository

import com.example.whatsappkotlin.domain.model.Message
import com.example.whatsappkotlin.util.Resource

interface MessagesRepository {

    suspend fun sendMessage(message: Message): Resource<Unit>

   // suspend fun fetchMessagesByChat(chatId: String): Resource<List<Message>>


}