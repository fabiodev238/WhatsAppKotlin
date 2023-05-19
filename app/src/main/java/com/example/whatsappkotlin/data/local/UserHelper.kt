package com.example.whatsappkotlin.data.local

import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.domain.model.User

object UserHelper {
    val userslist = listOf(
        User(
            id = "1",
            image = R.drawable.asset_cr7,
            name = "Cristiano Ronaldo"
        ),
        User(
            id = "2",
            image = R.drawable.asset_lewandowski,
            name = "Robert Lewandowsky"
        ),
        User(
            id = "3",
            image = R.drawable.asset_messi,
            name = "Lionel Messi"
        ),
        User(
            id = "4",
            image = R.drawable.asset_neymar,
            name = "Neymar Jr"
        ),
    )
}