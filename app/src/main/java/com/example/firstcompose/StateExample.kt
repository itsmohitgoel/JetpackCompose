package com.example.firstcompose

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NotificationScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {
        var  count = rememberSaveable{mutableStateOf(0)}
        NotificationCounter(count.value, {count.value++})
        MessageBar(count.value)
    }
}

@Composable
fun NotificationCounter(value : Int, increment: ()  -> Unit) {

    Column {
        Text(text = "You have sent ${value} notifications ")
        Button(onClick = {
            increment()
            Log.d("TAGGED", "Button clicked")
        }) {
            Text(text = "Send Notification")
        }
    }
}

@Composable
fun MessageBar(value: Int) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)

    ) {
        Row (Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
         Image(imageVector =  Icons.Outlined.Favorite , contentDescription = "",
             modifier = Modifier.padding(4.dp))
            Text(text = "Messages sent so far - $value")
        }
    }
}