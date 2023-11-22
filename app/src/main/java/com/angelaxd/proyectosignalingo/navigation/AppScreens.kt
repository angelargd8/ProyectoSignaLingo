package com.angelaxd.proyectosignalingo.navigation

sealed class AppScreens(val route: String){
    object LoginScreen: AppScreens("login")

    object SplashScreen: AppScreens("SplashScreen")

    object BuscarSenaScreen: AppScreens("BuscarSena")

    object MenuPrincipalScreen: AppScreens("MenuPrincipal")

    object PerfilScreen: AppScreens("Perfil")

    object QuienesSomosScreen: AppScreens("QuienesSomos")
    object GuardadosScreen: AppScreens("Guardados")
    object EmpiezaAprenderScreen: AppScreens("EmpiezaAprender")
    object HacerRecomendacionScreen: AppScreens("HacerRecomendacion")
    object ContenidoScreen: AppScreens("Contenido/{string}"){
        fun createRoute(string: String) = "Contenido/$string"
    }

    object SeniaScreen: AppScreens("Senia")

    object PruebaScreen: AppScreens("Prueba/{email}"){
        fun createRoute(email: String) = "Prueba/$email"
    }

    object SignInScreen: AppScreens("SignInScren/")


}
