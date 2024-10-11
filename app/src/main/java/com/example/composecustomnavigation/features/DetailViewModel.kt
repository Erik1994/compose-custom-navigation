package com.example.composecustomnavigation.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecustomnavigation.navigation.Navigator
import kotlinx.coroutines.launch

class DetailViewModel(
    private val navigator: Navigator
): ViewModel() {

    fun navigateToHome() {
        viewModelScope.launch {
            navigator.navigateUp()
        }
    }
}