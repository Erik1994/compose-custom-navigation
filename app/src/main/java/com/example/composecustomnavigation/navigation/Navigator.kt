package com.example.composecustomnavigation.navigation

import androidx.navigation.NavOptionsBuilder
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

interface Navigator {
    val startDestination: Destination
    val navigationAction: Flow<NavigateAction>

    suspend fun navigateUp()

    suspend fun navigate(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit = {}
    )
}

class DefaultNavigator(
    override val startDestination: Destination
) : Navigator {
    private val _navigationAction = Channel<NavigateAction>()
    override val navigationAction = _navigationAction.receiveAsFlow()

    override suspend fun navigateUp() {
        _navigationAction.send(NavigateAction.NavigateUp)
    }

    override suspend fun navigate(
        destination: Destination,
        navOptions: NavOptionsBuilder.() -> Unit
    ) {
        _navigationAction.send(
            NavigateAction.Navigate(
                destination = destination,
                navOptions = navOptions
            )
        )
    }
}