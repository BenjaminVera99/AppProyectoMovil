package com.example.appmovil.navigation

sealed class AppRoute (val route: String) {

    data object Home : AppRoute("HomePage")
    data object Profile : AppRoute("ProfilePage")
    data object Settings : AppRoute("SettingsPage")




}