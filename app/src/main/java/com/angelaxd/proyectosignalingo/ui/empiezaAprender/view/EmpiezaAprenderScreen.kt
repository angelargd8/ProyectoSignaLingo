package com.angelaxd.proyectosignalingo.ui.empiezaAprender.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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

@Composable
fun EmpiezaprenderScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldEmpiezaprenderScreen(navController, context)
}

@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldEmpiezaprenderScreen(navController: NavHostController, context: Context){
    // variable temporal para ense;ar informacion
    var categorias = listOf(context.getString(R.string.Verbos), context.getString(R.string.Adjetivos), context.getString(R.string.Personas), context.getString(R.string.Alimentos), context.getString(R.string.Calendarios),context.getString(R.string.Lugares), context.getString(R.string.Animales))


    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.Empieza)) },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {

        items(categorias){item ->
                Botones(navController , item, AppScreens.ContenidoScreen.route)

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
                .height(50.dp),
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
        ) {
            Text(text = s)
        }

    }

}

