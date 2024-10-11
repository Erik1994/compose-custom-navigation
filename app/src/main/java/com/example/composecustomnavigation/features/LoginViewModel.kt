package com.example.composecustomnavigation.features

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecustomnavigation.navigation.Destination
import com.example.composecustomnavigation.navigation.Navigator
import kotlinx.coroutines.launch

class LoginViewModel(
    private val navigator: Navigator
): ViewModel() {

    fun login() {
        viewModelScope.launch {
            navigator.navigate(
                destination = Destination.HomeGraph,
                navOptions = {
                    popUpTo(Destination.AuthGraph) {
                        inclusive = true
                    }
                }
            )
        }
    }
}