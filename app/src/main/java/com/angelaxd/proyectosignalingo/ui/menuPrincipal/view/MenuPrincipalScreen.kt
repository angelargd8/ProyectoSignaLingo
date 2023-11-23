package com.angelaxd.proyectosignalingo.ui.menuPrincipal.view

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.Imagen

@Composable
fun MenuPrincipalScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldMenuPrincipal(navController, context)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldMenuPrincipal(navController: NavHostController, context: Context){
    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.MenuPrincipal))},
        bottomBar = {FunBottomBar(navController)}

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                RowImagen()
                Botones(navController, context)
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
fun Botones(navController: NavHostController, context: Context){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.padding(start=80.dp).verticalScroll(state= scrollState)) {

        Spacer(modifier = Modifier.height(45.dp))
        Button( onClick =  { navController.navigate(route= AppScreens.EmpiezaAprenderScreen.route) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp),
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
        ) {
            Text(text = context.getString(R.string.Empieza))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button( onClick =  { navController.navigate(route= AppScreens.BuscarSenaScreen.route) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp),
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
        ) {
            Text(text = context.getString(R.string.Buscar))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button( onClick =  { navController.navigate(route= AppScreens.HacerRecomendacionScreen.route) },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp),
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
        ) {
            Text(text = context.getString(R.string.HacerRecomendacion))
        }
    }


}

