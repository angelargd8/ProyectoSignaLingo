package com.angelaxd.proyectosignalingo.ui.empiezaAprender.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.quienesSomos.view.FunCard

@Composable
fun EmpiezaprenderScreen(navController: NavHostController){
    funScaffoldEmpiezaprenderScreen(navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldEmpiezaprenderScreen(navController: NavHostController){
    Scaffold (
        topBar = { FunTopBar(navController, "Empieza prender") },
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