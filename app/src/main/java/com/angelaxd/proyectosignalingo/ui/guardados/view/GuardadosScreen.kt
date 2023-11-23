package com.angelaxd.proyectosignalingo.ui.guardados.view

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.data.Guardado
import com.angelaxd.proyectosignalingo.data.GuardadosState
import com.angelaxd.proyectosignalingo.ui.guardados.viewmodel.getGuardadosViewmodel
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.ListItemRow

@Composable
fun GuardadosScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldGuardados(navController, context)
}

//data class Images(var img: Int, var txt1 : String)



@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldGuardados(navController: NavHostController, context: Context){

    val viewModelGetGuardados : getGuardadosViewmodel = viewModel()

    when(val result = viewModelGetGuardados.response.value){
        is GuardadosState.Loading -> {
            Loading()
        }
        is GuardadosState.Success -> {
            var data = result.data
            //EstructuraGuardados(navController, result.data)

            //    topBar = { FunTopBar(navController, context.getString(R.string.Guardados)) },
            Scaffold (
                topBar = { FunTopBar(navController, context.getString(R.string.Guardados)) },
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
                        textos(navController, data)

                    }

                }
            }



        }
        is GuardadosState.Failure-> {
            Errorl(result)
        }
        else -> {
            Box(modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center){

                Text(
                    text = "...",
                    fontSize = 15.sp,
                    color = Color(0xFFE91E63),
                    overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
                )
            }
        }
    }


}

@Composable
fun textos(navController: NavHostController, data: MutableList<Guardado>) {
    //Text(text = data, fontSize = 30.sp)
    LazyColumn {
        items(data.size) { index ->
            //data[index].title?.let { Text(text = it, fontSize = 30.sp) }
            data[index].title?.let { ListItemRow(it,navController)}
        }
    }
}



@Composable
fun Loading() {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}

@Composable
fun Errorl(result: GuardadosState.Failure) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){

        Text(
            text = result.message,
            fontSize = 15.sp,
            color = Color(0xFFE91E63),
            overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
        )
    }

}


