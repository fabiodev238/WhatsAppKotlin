package com.example.whatsappkotlin.domain.model

import androidx.annotation.DrawableRes

data class Chat(
    val id: String,
    @DrawableRes val userImage: Int,

    val userOne : String,
    val userTwo : String,
    val userOneId : String,
    val userTwoId : String
)
