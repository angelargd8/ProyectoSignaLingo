package com.angelaxd.proyectosignalingo.ui.Contenido

import android.annotation.SuppressLint
import android.hardware.biometrics.BiometricManager.Strings
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.ui.buscarSeña.view.funScaffoldBuscar
import com.angelaxd.proyectosignalingo.ui.guardados.view.Images
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable

fun ContenidoScreen(navController: NavHostController){
    funScaffoldContenido(navController)
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldContenido(navController: NavHostController){
    var data = mutableStateListOf<Strings>()
    Scaffold (
        topBar = { FunTopBar(navController, "Verbos") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {

            items(data) { d ->

                //ListItemRow(d)
            }

        }
    }

}

@Composable
fun ListItemRow(item: String, modifier: Modifier = Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),

        ) {IconButton(onClick = { /* do something */ },
        Modifier
            .size(20.dp)
            .padding(5.dp),
    ) {
        //Icon(painter = painterResource(id = R.drawable.ic_favorito), contentDescription = "")
    }
        Text(text = item)
    }
}
