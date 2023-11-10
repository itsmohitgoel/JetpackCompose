package com.example.firstcompose.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstcompose.repository.TweetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(val repository: TweetRepository) : ViewModel() {

    val categories: StateFlow<Set<String>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getCategories()
        }
    }
}