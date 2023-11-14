package com.example.firstcompose.repository

import com.example.firstcompose.models.TweetDto
import com.example.firstcompose.remote.NetworkService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import retrofit2.Response
import javax.inject.Inject

class TweetRepository @Inject constructor(
    private val networkService: NetworkService
) {
    private val _categories = MutableStateFlow<Set<String>>(emptySet())
    val categories: StateFlow<Set<String>>
        get() = _categories

    private val _tweets = MutableStateFlow<List<TweetDto>>(emptyList())
    val tweets: StateFlow<List<TweetDto>>
        get() = _tweets

    suspend fun getCategories() {
        val response: Response<Set<String>> = networkService.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String) {
        val response = networkService.getTweets("tweets[?(@.category == \"$category\")]")
        if (response.isSuccessful && response.body() != null)
            _tweets.emit(response.body()!!)
    }
}