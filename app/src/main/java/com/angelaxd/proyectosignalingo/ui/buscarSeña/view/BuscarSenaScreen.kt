package com.angelaxd.proyectosignalingo.ui.buscarSeña.view

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.Contenido.viewmodel.data
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.ListItemRow

@Composable

fun BuscarSenaScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldBuscar(navController, context)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldBuscar(navController: NavHostController, context: Context){

    var query by remember{ mutableStateOf("") }
    var active by remember{ mutableStateOf(false) }
    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.Buscar)) },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column( modifier = Modifier
                .align(Alignment.TopCenter)){
                SearchBar(
                    modifier = Modifier
                        //.align(Alignment.TopCenter)
                        .semantics { traversalIndex = -1f },
                    query = query,
                    onQueryChange    = {query = it},
                    onSearch = {active = false},
                    active = active,
                    onActiveChange = {active = it},
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                ) {

                }
                Spacer(modifier = Modifier.height(5.dp))
                LazyColumn(){
                    val filteredContent = data.filter { it.contains(query, true) }
                    items(filteredContent) { dato ->
                        ListItemRow(dato,navController)
                    }
                }

            }


        }
    }
}



