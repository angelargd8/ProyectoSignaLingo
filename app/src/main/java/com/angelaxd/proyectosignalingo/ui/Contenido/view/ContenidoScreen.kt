package com.angelaxd.proyectosignalingo.ui.Contenido.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.ListItemRow

@Composable

fun ContenidoScreen(navController: NavHostController, string: String){
    funScaffoldContenido(navController,string)
}

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldContenido(navController: NavHostController, string: String){
    //val context = LocalContext.current
    val data = condicion(navController, string)  // condicion de que valor se mando de parametro


    Scaffold (
        topBar = { FunTopBar(navController, string) },
        bottomBar = { FunBottomBar(navController) }

    ){

        //
        Box(
            Modifier
                .fillMaxSize()
                .semantics { isTraversalGroup = true }){
            Column {
                Spacer(modifier = Modifier.height(70.dp))
                LazyColumn() {
                    items(data) { d -> ListItemRow(d, navController)}
                }

            }

        }
    }
}

@Composable
fun condicion(navController: NavHostController, string: String): List<String> {
    val context = LocalContext.current
    var dataa = listOf("")
    if (string == context.getString(R.string.Verbos)){
         dataa = listOf(
            context.getString(R.string.empezar),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }else if (string == context.getString(R.string.Adjetivos)){
        dataa = listOf(
            context.getString(R.string.Adjetivos),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }else if (string == context.getString(R.string.Personas)){
        dataa = listOf(
            context.getString(R.string.empezar),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }else if (string == context.getString(R.string.Alimentos)){
        dataa = listOf(
            context.getString(R.string.empezar),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }else if (string == context.getString(R.string.Calendarios)){
        dataa = listOf(
            context.getString(R.string.empezar),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }else if (string == context.getString(R.string.Lugares)){
        dataa = listOf(
            context.getString(R.string.empezar),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }else if (string == context.getString(R.string.Animales)){
        dataa = listOf(
            context.getString(R.string.empezar),
            context.getString(R.string.entender),
            context.getString(R.string.esconder),
            context.getString(R.string.extrañar),
            context.getString(R.string.fallar),
            context.getString(R.string.idear),
            context.getString(R.string.inspirar),
            context.getString(R.string.jugar)
        )


    }

    return dataa
}





