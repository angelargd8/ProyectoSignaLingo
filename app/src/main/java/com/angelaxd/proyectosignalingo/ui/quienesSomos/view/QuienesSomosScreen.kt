package com.angelaxd.proyectosignalingo.ui.quienesSomos.view

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.Texto
import com.angelaxd.proyectosignalingo.ui.objetos.Texto2

@Composable

fun QuienesSomosScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldQuienesSomos(navController,context)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldQuienesSomos(navController: NavHostController, context: Context){
    Scaffold (
        topBar = { FunTopBar(navController, "Quienes somos") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column(modifier = Modifier.fillMaxHeight()) {
                Spacer(modifier = Modifier.height(60.dp))
                FunCard(context)
            }

        }
    }

}

@Composable
fun FunCard(context: Context) {
    Card(
        modifier = Modifier
            .padding(25.dp),
        colors = CardDefaults.cardColors(
            Color(0xFF6650a4)
        )
            //.background(Color(0xFF6650a4))

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Texto(context.getString(R.string.Quienes))
        Texto2(context.getString(R.string.QuienesSomos))
        Spacer(modifier = Modifier.height(25.dp))
    }
}