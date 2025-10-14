package com.example.appmovil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appmovil.navigation.AppRoute
import com.example.appmovil.navigation.NavEvent
import com.example.appmovil.ui.screens.HomeScreen
import com.example.appmovil.ui.theme.AppMovilTheme
import com.example.appmovil.viewmodels.MainViewModel
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppMovilTheme {
                val viewModel: MainViewModel = viewModel()
                val navController = rememberNavController()
                LaunchedEffect(Unit) {
                viewModel.navigationEvents.collectLatest { event ->
                    when (event) {
                        is NavEvent.NavigateTo -> {
                            navController.navigate(event.route.route) {
                                event.popUpRoute?.let {
                                    popUpTo(it.route){
                                        inclusive = event.inclusive
                                    }
                                    launchSingleTop = event.singleTop
                                    restoreState = true
                                }
                            }

                            is NavEvent.PopBackStack -> navController.popBackStack()
                            is NavEvent.NavigateUp -> navController.navigateUp()
                        }
                    }
                }
            }
                Scaffold (
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    
                    NavHost(
                        navController = navController,
                        startDestination = AppRoute.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable(route= AppRoute.Home.route) {
                            HomeScreen(navController = navController, viewModel = viewModel())
                        }
                        composable(route= AppRoute.Profile.route) {
                            HomeScreen(navController = navController, viewModel = viewModel())
                        }
                        composable(route= AppRoute.Settings.route) {
                            HomeScreen(navController = navController, viewModel = viewModel())
                        }
                    }
                }
            }
        }
    }
}