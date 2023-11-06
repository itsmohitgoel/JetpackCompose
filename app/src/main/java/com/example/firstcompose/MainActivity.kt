package com.example.firstcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.firstcompose._11_produce_state.ProduceStateComp2
import com.example.firstcompose._12_derived_state.DerivedStateComp1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DerivedStateComp1()
        }
    }
}
