package com.angelaxd.proyectosignalingo.ui.perfil.view

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

fun PerfilScreen(navController: NavHostController){
    funScaffoldPerfil(navController)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldPerfil(navController: NavHostController){
    Scaffold (
        topBar = { FunTopBar(navController, "Menú Principal") },
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
