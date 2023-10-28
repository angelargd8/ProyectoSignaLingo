package com.angelaxd.proyectosignalingo.navigation

sealed class AppScreens(val route: String){
    object LoginScreen: AppScreens("login")

    object BuscarSenaScreen: AppScreens("BuscarSena")

    object MenuPrincipalScreen: AppScreens("MenuPrincipal")

    object PerfilScreen: AppScreens("Perfil")

    object QuienesSomosScreen: AppScreens("QuienesSomos")
    object GuardadosScreen: AppScreens("Guardados")


}
