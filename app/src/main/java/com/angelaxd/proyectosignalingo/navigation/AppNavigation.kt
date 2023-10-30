package com.angelaxd.proyectosignalingo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.angelaxd.proyectosignalingo.ui.Contenido.view.ContenidoScreen
import com.angelaxd.proyectosignalingo.ui.Seña.view.SeniaScreen
import com.angelaxd.proyectosignalingo.ui.buscarSeña.view.BuscarSenaScreen
import com.angelaxd.proyectosignalingo.ui.empiezaAprender.view.EmpiezaprenderScreen
import com.angelaxd.proyectosignalingo.ui.guardados.view.GuardadosScreen
import com.angelaxd.proyectosignalingo.ui.hacerRecomendacion.view.HacerRecomendacionScreen
import com.angelaxd.proyectosignalingo.ui.login.view.LoginScreen
import com.angelaxd.proyectosignalingo.ui.menuPrincipal.view.MenuPrincipalScreen
import com.angelaxd.proyectosignalingo.ui.perfil.view.PerfilScreen
import com.angelaxd.proyectosignalingo.ui.quienesSomos.view.QuienesSomosScreen

@Composable
fun AppNavigation(){
    val navController= rememberNavController();

    NavHost(navController = navController, startDestination = AppScreens.LoginScreen.route ){
        composable(route = AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route= AppScreens.MenuPrincipalScreen.route){
            MenuPrincipalScreen(navController)
        }
        composable(route= AppScreens.PerfilScreen.route){
            PerfilScreen(navController)
        }
        composable(route= AppScreens.QuienesSomosScreen.route){
            QuienesSomosScreen(navController)
        }
        composable(route= AppScreens.GuardadosScreen.route){
            GuardadosScreen(navController)
        }
        composable(route= AppScreens.BuscarSenaScreen.route){
            BuscarSenaScreen(navController)
        }
        composable(route= AppScreens.EmpiezaAprenderScreen.route){
            EmpiezaprenderScreen(navController)
        }
        composable(route= AppScreens.HacerRecomendacionScreen.route){
            HacerRecomendacionScreen(navController)
        }
        composable(route= AppScreens.ContenidoScreen.route){
            ContenidoScreen(navController)
        }
        composable(route= AppScreens.SeniaScreen.route){
            SeniaScreen(navController)
        }

    }

}

