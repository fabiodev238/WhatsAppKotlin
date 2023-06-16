package com.example.whatsappkotlin.data.remote.repository

import com.example.whatsappkotlin.data.remote.repository.Constants.DEFAULT_NETWORK_ERROR
import com.example.whatsappkotlin.domain.model.Message
import com.example.whatsappkotlin.domain.repository.MessagesRepository
import com.example.whatsappkotlin.util.Resource
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class MessagesRepositoryImpl @Inject constructor (
    private val firebaseFirestore : FirebaseFirestore
        ): MessagesRepository {

    override suspend fun sendMessage( message:Message): Resource<Unit> {
        return try {
            var isSuccessful = false
            firebaseFirestore.collection(message.chatId)
                .document(message.id)
                .set(message, SetOptions.merge())
                .addOnCompleteListener { isSuccessful = it.isSuccessful }
                .await()

            if (isSuccessful) {
                Resource.Success(Unit)
            } else {
                Resource.Error(DEFAULT_NETWORK_ERROR)
            }

        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }


    // override suspend fun fetchMessagesByChat(chatId: String): Resource<List<Message>> {

   // } 19:50 ya podemos mandar mensajes 5<<<


}