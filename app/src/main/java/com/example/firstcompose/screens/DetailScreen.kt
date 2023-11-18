package com.example.firstcompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firstcompose.models.TweetDto
import com.example.firstcompose.viewmodels.DetailViewModel

@Composable
fun DetailScreen() {
    val viewModel: DetailViewModel = hiltViewModel()
    val tweets = viewModel.tweets.collectAsState()

    TweetList(data = tweets.value)
}

@Composable
fun TweetList(data: List<TweetDto>) {
    LazyColumn() {
        items(data) { tweet ->
            TweetListItem(tweet = tweet.text)
        }
    }
}

@Composable
fun TweetListItem(tweet: String) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(8.dp),
        border = BorderStroke(1.dp, Color(0xFFEEEEEE)),
        content = {
            Text(
                text = tweet,
                modifier = Modifier
                    .padding(16.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }
    )
}