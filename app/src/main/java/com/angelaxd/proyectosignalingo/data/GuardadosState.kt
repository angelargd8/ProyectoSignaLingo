package com.angelaxd.proyectosignalingo.data

sealed class GuardadosState{
    class Success(val data: MutableList<Guardado>): GuardadosState()
    class Failure(val message: String): GuardadosState()
    object Loading: GuardadosState()
    object Empty : GuardadosState()
}
