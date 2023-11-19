package com.angelaxd.proyectosignalingo.ui.hacerRecomendacion.view

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable

fun HacerRecomendacionScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldHacerRecomendacion(navController, context)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldHacerRecomendacion(navController: NavHostController, context: Context){
    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.HacerRecomendacion)) },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                //Spacer(modifier = Modifier.height(60.dp))
                //FunCard()
            }

        }
    }

}