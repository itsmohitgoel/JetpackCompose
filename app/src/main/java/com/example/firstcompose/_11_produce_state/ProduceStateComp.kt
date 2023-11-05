package com.example.firstcompose._11_produce_state

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay

@Preview(showSystemUi = true)
@Composable
fun ProduceStateComp() {
    val state = remember { mutableStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        for (i in 1..10) {
            delay(1000)
            state.value++
        }
    }

    val state2 = produceState(initialValue = 10) {
        for (i in 11..20) {
            delay(1000)
            value++
        }
    }

    Column {
        Text(
            text = state.value.toString(),
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = state2.value.toString(),
            style = MaterialTheme.typography.headlineLarge
        )

    }
}