package com.angelaxd.proyectosignalingo.ui.Contenido.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.Contenido.viewmodel.data
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable

fun ContenidoScreen(navController: NavHostController){
    funScaffoldContenido(navController)
}

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldContenido(navController: NavHostController){
    val data = data

    Scaffold (
        topBar = { FunTopBar(navController, "Verbos") },
        bottomBar = { FunBottomBar(navController) }

    ){

        Spacer(modifier = Modifier.height(50.dp))
        Box(
            Modifier
                .fillMaxSize()
                .semantics { isTraversalGroup = true }){
            LazyColumn() {
                 items(data) { d -> ListItemRow(d, navController)}
            }

        }
    }
}

@Composable
fun ListItemRow(item: String, navController: NavHostController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),

        ) {IconButton(onClick = {
        navController.navigate(route= AppScreens.HacerRecomendacionScreen.route)
    },
        Modifier
            .size(30.dp)
            .padding(5.dp),
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_icono), contentDescription = "")
    }
        Text(text = item, )

    }
}