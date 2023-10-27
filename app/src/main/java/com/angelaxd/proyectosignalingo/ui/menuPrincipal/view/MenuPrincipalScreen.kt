package com.angelaxd.proyectosignalingo.ui.menuPrincipal.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
@Composable
fun MenuPrincipalScreen(navController: NavHostController){

    funScaffold()

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffold(){
    Scaffold (
        topBar = {TopAppBar(title = { Text(text = "SignaLingo") })}
        //snackbarHost = {},
        //content = {},
        //floatingActionButton = {},
        //floatingActionButtonPosition = {},
        //bottomBar = {},

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("Hola mundo!", modifier = Modifier.align(Alignment.Center))
        }
    }

}
