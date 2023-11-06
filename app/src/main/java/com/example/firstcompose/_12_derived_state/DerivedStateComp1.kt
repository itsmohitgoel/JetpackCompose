package com.example.firstcompose._12_derived_state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun DerivedStateComp1() {
    val tableOf = remember { mutableStateOf(5) }
    val index = produceState(initialValue = 1) {
        repeat(9) {
            delay(1000)
            value++
        }
    }

    val message =
        remember { derivedStateOf { "${tableOf.value} * ${index.value} = ${tableOf.value * index.value}" } }

    Box(
        modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message.value,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}