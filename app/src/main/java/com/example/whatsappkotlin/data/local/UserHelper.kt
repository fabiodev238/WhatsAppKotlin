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
            image = R.drawable.asset_messi,
            name = "Lionel Messi"
        ),
        User(
            id = "3",
            image = R.drawable.asset_lewandowski,
            name = "Robert Lewandowsky"
        ),

        User(
            id = "4",
            image = R.drawable.asset_neymar,
            name = "Neymar Jr"
        ),
    )
    val cristianoChatList = listOf(
        Chat(
            id = "22",
            userImage = R.drawable.asset_messi,
            userOne = "Cristiano Ronaldo",
            userTwo = "Lionel Messi",
            userOneId = "1",
            userTwoId = "2"
        ),
        Chat(
            id = "11",
            userImage = R.drawable.asset_lewandowski,
            userOne = "Cristiano Ronaldo",
            userTwo = "Robert Lewandowski",
            userOneId = "1",
            userTwoId = "3"
        ),

        Chat(
            id = "33",
            userImage = R.drawable.asset_neymar,
            userOne = "Cristiano Ronaldo",
            userTwo = "Neymar Jr",
            userOneId = "1",
            userTwoId = "4"
        ),
    )

    val messiChatList = listOf(
        Chat(
            id = "22",
            userImage = R.drawable.asset_cr7,
            userOne = "Lionel Messi",
            userTwo = "Cristiano Ronaldo",
            userOneId = "2",
            userTwoId = "1"
        ),
        Chat(
            id = "44",
            userImage = R.drawable.asset_lewandowski,
            userOne = "Lionel Messi",
            userTwo = "Robert Lewandowski",
            userOneId = "2",
            userTwoId = "3"
        ),
        Chat(
            id = "55",
            userImage = R.drawable.asset_neymar,
            userOne = "Lionel Messi",
            userTwo = "Neymar Jr",
            userOneId = "2",
            userTwoId = "4"
        ),
    )

    val lewandowskiChatList = listOf(
        Chat(
            id = "11",
            userImage = R.drawable.asset_cr7,
            userOne = "Robert Lewandowski",
            userTwo = "Cristiano Ronaldo",
            userOneId = "3",
            userTwoId = "1"
        ),
        Chat(
            id = "44",
            userImage = R.drawable.asset_messi,
            userOne = "Robert Lewandowski",
            userTwo = "Lionel Messi",
            userOneId = "3",
            userTwoId = "2"
        ),
        Chat(
            id = "66",
            userImage = R.drawable.asset_neymar,
            userOne = "Robert Lewandowski",
            userTwo = "Neymar Jr",
            userOneId = "3",
            userTwoId = "4"
        ),
    )

    val neymarChatList = listOf(
        Chat(
            id = "33",
            userImage = R.drawable.asset_cr7,
            userOne = "Neymar Jr",
            userTwo = "Cristiano Ronaldo",
            userOneId = "4",
            userTwoId = "1"
        ),
        Chat(
            id = "55",
            userImage = R.drawable.asset_messi,
            userOne = "Neymar Jr",
            userTwo = "Lionel Messi",
            userOneId = "4",
            userTwoId = "2"
        ),
        Chat(
            id = "66",
            userImage = R.drawable.asset_lewandowski,
            userOne = "Neymar Jr",
            userTwo = "Robert Lewandowski",
            userOneId = "4",
            userTwoId = "3"
        ),
    )

}