package com.example.firstcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchEffectComposable()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun LaunchEffectComposable() {
    val counter = remember { mutableStateOf(0) }
    var scope = rememberCoroutineScope()

    LaunchedEffect(key1 = Unit) {
        Log.d("LaunchEffectComposable", "Started..")
        try {
            for (i in 1..10) {
                counter.value++
                delay(1000)
            }
        } catch (e: Exception) {
            Log.d("LaunchEffectComposable", e.message.toString())
        }
    }

    var text = "Counter is Running | ${counter.value}"
    if (counter.value == 10) {
        text = "Counter Stopped"
    }
    Text(text = text)
}