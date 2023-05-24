package com.example.whatsappkotlin.data.local

import com.example.whatsappkotlin.R
import com.example.whatsappkotlin.domain.model.Chat
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
    val chatList = listOf(
        Chat(
            id = "1",
            userImage = R.drawable.asset_cr7,
            userName = "Cristiano Ronaldo"
        ),
        Chat(
            id = "2",
            userImage = R.drawable.asset_lewandowski,
            userName = "Robert Lewandowsky"
        ),
        Chat(
            id = "3",
            userImage = R.drawable.asset_messi,
            userName = "Lionel Messi"
        ),
        Chat(
            id = "4",
            userImage = R.drawable.asset_neymar,
            userName = "Neymar Jr"
        ),
    )


}