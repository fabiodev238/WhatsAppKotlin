package com.example.whatsappkotlin.domain.model

import androidx.annotation.DrawableRes

data class User(
    val id : String,
    @DrawableRes val image : Int,
    val name: String
)
