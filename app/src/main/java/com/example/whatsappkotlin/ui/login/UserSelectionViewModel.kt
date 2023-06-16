package com.example.whatsappkotlin.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappkotlin.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserSelectionViewModel @Inject constructor(    private val userRepository : UserRepository): ViewModel() {

    fun saveUserSelection(useId: String) {
        viewModelScope.launch {
            userRepository.saveUserId(useId)
        }
    }
}