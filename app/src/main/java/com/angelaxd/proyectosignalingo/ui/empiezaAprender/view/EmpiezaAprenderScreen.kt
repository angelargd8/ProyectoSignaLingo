package com.angelaxd.proyectosignalingo.ui.empiezaAprender.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.guardados.view.Images
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable
fun EmpiezaprenderScreen(navController: NavHostController){
    funScaffoldEmpiezaprenderScreen(navController)
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldEmpiezaprenderScreen(navController: NavHostController){
    var categorias = listOf("Verbos", "Adjetivos", "Personas", "Alimentos", "Calendarios", "")
    Scaffold (
        topBar = { FunTopBar(navController, "Empieza prender") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column(Modifier.verticalScroll(rememberScrollState())){

                Botones(navController , "Verbos", AppScreens.EmpiezaAprenderScreen.route)
                Botones(navController , "Adjetivos", AppScreens.EmpiezaAprenderScreen.route)
                Botones(navController , "Personas", AppScreens.EmpiezaAprenderScreen.route)
                Botones(navController , "Alimentos", AppScreens.EmpiezaAprenderScreen.route)
                Botones(navController , "Calendarios", AppScreens.EmpiezaAprenderScreen.route)
                Botones(navController , "Lugares", AppScreens.EmpiezaAprenderScreen.route)
                Botones(navController , "Animales", AppScreens.EmpiezaAprenderScreen.route)

            }

        }
    }

}
@Composable
fun Botones(navController: NavHostController, s:String, route: String){
    Column(modifier = Modifier.padding(start=80.dp)) {

        Spacer(modifier = Modifier.height(45.dp))
        Button( onClick =  { navController.navigate(route= route.toString()) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp)
        ) {
            Text(text = s)
        }

    }

}

