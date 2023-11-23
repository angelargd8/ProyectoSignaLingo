package com.angelaxd.proyectosignalingo.ui.empiezaAprender.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.Botones
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable
fun EmpiezaprenderScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldEmpiezaprenderScreen(navController, context)
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldEmpiezaprenderScreen(navController: NavHostController, context: Context){
    // variable temporal para ense;ar informacion (se puede incluir en firebase o dejarlo aqui)
    var categorias = listOf(context.getString(R.string.Verbos), context.getString(R.string.Alimentos), context.getString(R.string.Calendarios),context.getString(R.string.Lugares), context.getString(R.string.Animales)) //listOf(context.getString(R.string.Verbos), context.getString(R.string.Adjetivos), context.getString(R.string.Alimentos), context.getString(R.string.Calendarios),context.getString(R.string.Lugares), context.getString(R.string.Animales))

    // encabezado y menu inferior
    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.Empieza)) },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {

            // muestra los botones de categorias
        items(categorias){item ->
                Botones(navController , item) // funcion botones en objetos
            }

        }
    }

}


