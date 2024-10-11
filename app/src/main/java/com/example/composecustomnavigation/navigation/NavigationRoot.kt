package com.example.composecustomnavigation.navigation

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.toRoute
import com.example.composecustomnavigation.features.DetailScreen
import com.example.composecustomnavigation.features.DetailViewModel
import com.example.composecustomnavigation.features.HomeScreen
import com.example.composecustomnavigation.features.HomeViewModel
import com.example.composecustomnavigation.features.LoginScreen
import com.example.composecustomnavigation.features.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavigationRoot(
    innerPaddings: PaddingValues,
    navController: NavHostController,
    startDestination: Destination
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = Modifier.padding(paddingValues = innerPaddings)
    ) {
        authGraph()
        homeGraph()
    }
}

fun NavGraphBuilder.authGraph() {
    navigation<Destination.AuthGraph>(startDestination = Destination.LoginScreen) {
        composable<Destination.LoginScreen> {
            val viewModel = koinViewModel<LoginViewModel>()
            LoginScreen(onLoginClick = viewModel::login)
        }
    }
}

fun NavGraphBuilder.homeGraph() {
    navigation<Destination.HomeGraph>(startDestination = Destination.HomeScreen) {
        composable<Destination.HomeScreen> {
            val viewModel = koinViewModel<HomeViewModel>()
            HomeScreen(onDetailClick = viewModel::navigateToDetail)
        }
        composable<Destination.DetailsScreen> {
            val viewModel = koinViewModel<DetailViewModel>()
            val args = it.toRoute<Destination.DetailsScreen>()
            DetailScreen(id = args.id, onGoBackClick = viewModel::navigateToHome)
        }
    }
}