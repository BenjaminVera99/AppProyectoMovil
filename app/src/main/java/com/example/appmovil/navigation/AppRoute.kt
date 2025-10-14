package com.example.appmovil.navigation

sealed class AppRoute (val route: String) {

    data object Home : AppRoute("HomePage")
    data object Profile : AppRoute("ProfilePage")

    data object Settings : AppRoute("SettingsPage")

    data class Detail(val itemId: String) : AppRoute("detail_page/{itemId}") {
        fun buildRoute(): String {
            return route.replace("{itemId}", itemId)
        }
    }




}