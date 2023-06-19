package com.example.whatsappkotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatsappkotlin.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {


    private val _userId: MutableLiveData<String> = MutableLiveData()
    val userId: LiveData<String>
        get() = _userId

    private val _hasSplashFinished: MutableLiveData<Unit> = MutableLiveData()
    val hasSplashFinished: LiveData<Unit>
        get() = _hasSplashFinished

    init {
        _userId.value = userRepository.getUserId()
    }

    fun checkUserSelection() {
        viewModelScope.launch {
            _hasSplashFinished.value = Unit
        }
    }
}