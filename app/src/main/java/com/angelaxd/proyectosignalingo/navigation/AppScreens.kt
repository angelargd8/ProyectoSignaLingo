package com.angelaxd.proyectosignalingo.navigation

sealed class AppScreens(val route: String){
    object LoginScreen: AppScreens("login")

    object BuscarSenaScreen: AppScreens("BuscarSena")

    object MenuPrincipalScreen: AppScreens("MenuPrincipal/{email}"){
        fun createRoute(email: String) = "MenuPrincipal/$email"
    }

    object PerfilScreen: AppScreens("Perfil/{email}"){
        fun createRoute(email: String) = "Perfil/$email"
    }

    object QuienesSomosScreen: AppScreens("QuienesSomos")
    object GuardadosScreen: AppScreens("Guardados")
    object EmpiezaAprenderScreen: AppScreens("EmpiezaAprender")
    object HacerRecomendacionScreen: AppScreens("HacerRecomendacion")
    object ContenidoScreen: AppScreens("Contenido")
    object SeniaScreen: AppScreens("Senia")

    object PruebaScreen: AppScreens("Prueba/{email}"){
        fun createRoute(email: String) = "Prueba/$email"
    }

    object SignInScreen: AppScreens("SignInScren/")


}
