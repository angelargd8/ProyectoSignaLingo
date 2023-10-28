package com.angelaxd.proyectosignalingo.ui.menuPrincipal.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.buscarSeña.view.BuscarSenaScreen
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.Imagen

@Composable
fun MenuPrincipalScreen(navController: NavHostController){

    funScaffoldMenuPrincipal(navController)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldMenuPrincipal(navController: NavHostController){
    Scaffold (
        topBar = { FunTopBar(navController, "Menú Principal")},
        bottomBar = {FunBottomBar(navController)}

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                RowImagen()
                Botones(navController)
            }

        }
    }

}


@Composable
fun RowImagen(){
    Row( modifier = Modifier.padding(start=50.dp)) {
        Imagen("https://i.imgur.com/WxKT7KF.png", 800,800)
    }
}
@Composable
fun Botones(navController: NavHostController){
    Column(modifier = Modifier.padding(start=80.dp)) {

        Spacer(modifier = Modifier.height(45.dp))
        Button( onClick =  { navController.navigate(route= AppScreens.EmpiezaAprenderScreen.route) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp)
        ) {
            Text(text = "Empieza a aprender")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button( onClick =  { navController.navigate(route= AppScreens.BuscarSenaScreen.route) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp)
        ) {
            Text(text = "Buscar seña")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button( onClick =  { navController.navigate(route= AppScreens.HacerRecomendacionScreen.route) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp)
        ) {
            Text(text = "Hacer recomendación")
        }
    }


}

