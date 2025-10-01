package com.example.appmovil.navigation

sealed class NavEvent {

    data class NavigateTo(
        val route: AppRoute,
        val popUpRoute: AppRoute? = null,
        val inclusive:Boolean=false,
        val singleTop:Boolean=false): NavEvent()

    object PopBackStack : NavEvent()

    object NavigateUp : NavEvent()

}