package com.example.appmovil.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.appmovil.navigation.AppRoute
import com.example.appmovil.viewmodel.MainViewModel
import com.example.appmovil.viewmodel.ViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: MainViewModel = ViewModel()
){
    val items = listOf(AppRoute.Home, AppRoute.Profile)
    var selectedItem by remember { mutableStateOf(1) }

    Scaffold (
        bottomBar = {
            NavigationBar {
                items.forEachIndexed { index, AppRoute ->
                    NavigationBarItem(
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            viewModel.navigateTo()
                        },
                        label = { Text( ) },
                        icon = {
                            Icon(imageVector = if ())
                            contentDescription =
                        }
                    )
                }
            }
        }
    )
}
