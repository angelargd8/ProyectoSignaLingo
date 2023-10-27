package com.angelaxd.proyectosignalingo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.angelaxd.proyectosignalingo.ui.login.view.LoginScreen
import com.angelaxd.proyectosignalingo.ui.menuPrincipal.view.MenuPrincipalScreen

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

    }

}

