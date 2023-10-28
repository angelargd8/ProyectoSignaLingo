package com.angelaxd.proyectosignalingo.ui.guardados.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable

fun GuardadosScreen(navController: NavHostController){
    funScaffoldGuardados(navController)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldGuardados(navController: NavHostController){
    Scaffold (
        topBar = { FunTopBar(navController, "Guardados") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                //RowImagen()
                //Botones(navController)
                Text("Hola mundo!", )
            }

        }
    }

}
