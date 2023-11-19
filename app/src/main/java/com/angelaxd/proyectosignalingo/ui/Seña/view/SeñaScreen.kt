package com.angelaxd.proyectosignalingo.ui.Seña.view


import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable

fun SeniaScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldSenia(navController, context)
}

@SuppressLint("UnrememberedMutableState", "UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldSenia(navController: NavHostController, context: Context){

    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.Verbos)) },
        bottomBar = { FunBottomBar(navController) }

    ){

        Spacer(modifier = Modifier.height(50.dp))

        Box(
            Modifier
                .fillMaxSize()
                .semantics { isTraversalGroup = true }){


        }
    }
}
