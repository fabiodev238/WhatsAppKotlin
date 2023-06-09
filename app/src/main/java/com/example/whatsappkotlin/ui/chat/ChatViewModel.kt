package com.example.whatsappkotlin.ui.chat

import androidx.lifecycle.*
import com.example.whatsappkotlin.domain.model.Message
import com.example.whatsappkotlin.domain.repository.usecase.FetchMessageRealTimeUseCase
import com.example.whatsappkotlin.domain.repository.usecase.SendMessageUseCase
import com.example.whatsappkotlin.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class ChatViewModel @Inject constructor(

    private val sendMessageUseCase: SendMessageUseCase,
    private val fetchMessageRealTimeUseCase: FetchMessageRealTimeUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _messagesListState: MutableLiveData<Resource<List<Message>>> = MutableLiveData()
    val messagesListState: LiveData<Resource<List<Message>>>
        get() = _messagesListState

    private val _sendMessageState: MutableLiveData<Resource<Unit>> = MutableLiveData()
    val sendMessageState: LiveData<Resource<Unit>>
        get() = _sendMessageState

    init {
        val chatId = savedStateHandle.get<String>("chatId")

        if (!chatId.isNullOrEmpty()){
            getMessages(chatId = chatId)
        }

    }

    private fun getMessages(chatId: String) {
        viewModelScope.launch {
            fetchMessageRealTimeUseCase(chatId).onEach {
                _messagesListState.value = it
            }.launchIn(viewModelScope)
        }
    }

    fun sendMessage(message: Message) {
        viewModelScope.launch {
            sendMessageUseCase(message).onEach {
                _sendMessageState.value = it
            }.launchIn(viewModelScope)
        }
    }

}
