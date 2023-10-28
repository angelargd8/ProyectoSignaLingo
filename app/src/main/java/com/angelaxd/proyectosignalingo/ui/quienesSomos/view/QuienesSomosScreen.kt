package com.angelaxd.proyectosignalingo.ui.quienesSomos.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.menuPrincipal.view.Botones
import com.angelaxd.proyectosignalingo.ui.menuPrincipal.view.RowImagen
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.Texto
import com.angelaxd.proyectosignalingo.ui.objetos.Texto2

@Composable

fun QuienesSomosScreen(navController: NavHostController){
    funScaffoldQuienesSomos(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldQuienesSomos(navController: NavHostController){
    Scaffold (
        topBar = { FunTopBar(navController, "Quienes somos") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                Spacer(modifier = Modifier.height(60.dp))
                FunCard()
            }

        }
    }

}

@Composable
fun FunCard(){
    Card {
        Texto("¿Quienes Somos?")
        Texto2("SignaLingo es un proyecto el cual tiene como objetivo el brindar un servicio de aprendizaje y educación visual para enseñar lengua de señas enfocado en personas guatemaltecas hispano hablantes que deseen aprender  nuevas palabras que sean de su utilidad . Este proyecto es desarrollado por estudiantes de la Universidad del Valle de Guatemala.")
    }
}