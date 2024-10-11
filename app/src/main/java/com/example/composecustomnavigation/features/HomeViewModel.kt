package com.example.composecustomnavigation.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecustomnavigation.navigation.Destination
import com.example.composecustomnavigation.navigation.Navigator
import kotlinx.coroutines.launch

class HomeViewModel(
    private val navigator: Navigator
): ViewModel() {

    fun navigateToDetail(id: String) {
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.DetailsScreen(id = id),
            )
        }
    }
}