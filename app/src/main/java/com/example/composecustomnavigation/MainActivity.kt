package com.example.composecustomnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.composecustomnavigation.navigation.NavigateAction
import com.example.composecustomnavigation.navigation.NavigationRoot
import com.example.composecustomnavigation.navigation.Navigator
import com.example.composecustomnavigation.ui.theme.ComposeCustomNavigationTheme
import com.example.composecustomnavigation.util.ObserveAsEvents
import org.koin.compose.koinInject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeCustomNavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    val navigator = koinInject<Navigator>()
                    ObserveAsEvents(flow = navigator.navigationAction) { action ->
                        when(action) {
                            is NavigateAction.Navigate -> navController.navigate(
                                route = action.destination
                            ) {
                                action.navOptions(this)
                            }
                            NavigateAction.NavigateUp -> navController.navigateUp()
                        }
                    }
                    NavigationRoot(
                        innerPaddings = innerPadding,
                        navController = navController,
                        startDestination = navigator.startDestination
                    )
                }
            }
        }
    }
}