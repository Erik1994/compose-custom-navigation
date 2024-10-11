package com.example.composecustomnavigation.navigation

import androidx.navigation.NavOptionsBuilder

sealed interface NavigateAction {
    data class Navigate(
        val destination: Destination,
        val navOptions: NavOptionsBuilder.() -> Unit = {}
    ) : NavigateAction

    data object NavigateUp : NavigateAction
}