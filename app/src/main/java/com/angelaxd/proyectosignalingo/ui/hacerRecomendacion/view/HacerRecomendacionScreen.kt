package com.angelaxd.proyectosignalingo.ui.hacerRecomendacion.view

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.hacerRecomendacion.viewmodel.HacerRecomendacionViewmodel
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable

fun HacerRecomendacionScreen(navController: NavHostController){
    val context = LocalContext.current
    val viewModelRecomendacion : HacerRecomendacionViewmodel = viewModel()
    funScaffoldHacerRecomendacion(navController, context, viewModelRecomendacion)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldHacerRecomendacion(
    navController: NavHostController,
    context: Context,
    viewModelRecomendacion: HacerRecomendacionViewmodel
){
    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.HacerRecomendacion)) },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column( modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
                )
            {
                Spacer(modifier = Modifier.height(30.dp))
                FunForm(navController,context, viewModelRecomendacion )
            }

        }
    }

}

@Composable
fun FunForm(
    navController: NavHostController,
    context: Context,
    viewModelRecomendacion: HacerRecomendacionViewmodel
) {
    var titulo by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }

    Card (shape = RoundedCornerShape(10.dp), modifier = Modifier
        .fillMaxWidth(),
        //.padding(60.dp),
        //.wrapContentHeight(),
        colors = CardDefaults.cardColors(
            Color(0xC16650A4)
        )
    ){
        Column (verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text(context.getString(R.string.titulo)) }

            )
            Spacer(modifier = Modifier.height(30.dp))
            TextField(
                value = descripcion,
                onValueChange = { descripcion = it },
                label = { Text(context.getString(R.string.IngresarRecomendacion)) }
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button( onClick =  {

                viewModelRecomendacion.createRecomendacion(titulo, descripcion){
                    navController.navigate(route= AppScreens.MenuPrincipalScreen.route)
                }


            },
                modifier= Modifier
                    .width(200.dp)
                    .height(45.dp),
                colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650A4), contentColor = Color.White)
            ) {
                Text(text = context.getString(R.string.HacerRecomendacion))
            }
            Spacer(modifier = Modifier.height(40.dp))

        }




    }

}