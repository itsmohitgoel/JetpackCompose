package com.example.firstcompose.remote

import com.example.firstcompose.models.TweetDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface NetworkService {
    @GET("/v3/b/660383332b1b334a633bf063?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): Response<List<TweetDto>>

    @GET("/v3/b/660383332b1b334a633bf063?meta=false")
    @Headers("X-JSON-Path:tweets..category")
    suspend fun getCategories(): Response<Set<String>>
}