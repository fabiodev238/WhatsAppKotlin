package com.example.whatsappkotlin.domain.model

import androidx.annotation.DrawableRes

data class Chat(
    val id: String,
    @DrawableRes val userImage: Int,
    val userName : String
)
