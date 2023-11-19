package com.angelaxd.proyectosignalingo.ui.objetos

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun PruebaScreen(
    navController: NavHostController,
    email: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally)
    {
        Texto(texto = email)
    }

}