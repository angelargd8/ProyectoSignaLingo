package com.angelaxd.proyectosignalingo.navigation

sealed class AppScreens(val route: String){
    object LoginScreen: AppScreens("login")

    object BuscarSenaScreen: AppScreens("BuscarSena")

    object MenuPrincipalScreen: AppScreens("MenuPrincipal")

    object PerfilScreen: AppScreens("Perfil")

    object QuienesSomosScreen: AppScreens("QuienesSomos")
    object GuardadosScreen: AppScreens("Guardados")
    object EmpiezaAprenderScreen: AppScreens("EmpiezaAprender")
    object HacerRecomendacionScreen: AppScreens("HacerRecomendacion")
    object ContenidoScreen: AppScreens("Contenido")
    object SeniaScreen: AppScreens("Senia")


}
