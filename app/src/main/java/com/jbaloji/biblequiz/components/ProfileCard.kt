package com.jbaloji.biblequiz.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.auth.FirebaseUser
import com.jbaloji.biblequiz.R
import com.jbaloji.biblequiz.presentation.home.HomeScreen

@Composable
fun ProfileCard(
    user:FirebaseUser
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box() {
            Icon(
                painter = painterResource(id = R.drawable.user),
                contentDescription = "Profile Image" )
        }
        Text(text = user.displayName.toString())
        Text(text = "user Description")

    }

}

