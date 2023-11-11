package com.example.firstcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.models.TweetDto
import com.example.firstcompose.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(val repository: TweetRepository) : ViewModel() {

    val categories: StateFlow<List<TweetDto>>
        get() = repository.tweets

    init {
        viewModelScope.launch {
            repository.getTweets("android")
        }
    }
}