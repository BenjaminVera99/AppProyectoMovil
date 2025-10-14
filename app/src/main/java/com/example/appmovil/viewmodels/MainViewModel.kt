package com.example.appmovil.viewmodels

import com.example.appmovil.navigation.AppRoute
import com.example.appmovil.navigation.NavEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){

    private val _navEvents = MutableSharedFlow<NavEvent>()

    val navigationEvents: SharedFlow<NavEvent> = _navEvents.asSharedFlow()

    // para emitir los eventos de navegacion
    fun navigateTo(appRoute: AppRoute){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavEvent.NavigateTo(route = appRoute))
        }
    }

    // Para volver atras
    fun navigateBack(){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavEvent.PopBackStack)
        }
    }

    // Para navegar hacia arriba
    fun navigateUp(){
        CoroutineScope(Dispatchers.Main).launch {
            _navEvents.emit(NavEvent.NavigateUp)
        }
    }




}