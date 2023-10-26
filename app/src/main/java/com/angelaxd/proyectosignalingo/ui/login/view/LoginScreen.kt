package com.angelaxd.proyectosignalingo.ui.login.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.objetos.Imagen

@Composable
fun LoginScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(state= scrollState))
    {
        BoxFun(navController)
    }

}


@Composable
fun BoxFun(navController: NavHostController){
    Box(modifier= Modifier
        .fillMaxWidth()
        .fillMaxHeight()

    ) {
        Column {
            Imagen("https://i.imgur.com/5cDS0Jv.png")
            //Spacer(modifier = Modifier.height(1.dp))
            FunRows(navController)
        }

    }

}

@Composable
fun FunRows(navController: NavHostController){
    Row {
        FunButton(navController)
    }
}

@Composable
fun FunButton(navController: NavHostController){
    Button(onClick =  { navController.navigate(route= AppScreens.MenuPrincipalScreen.route) }) {
        Text(text = "Ingresar sesión")
    }
}