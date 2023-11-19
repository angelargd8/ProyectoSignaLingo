package com.angelaxd.proyectosignalingo.ui.perfil.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.angelaxd.proyectosignalingo.ui.objetos.Imagen
import com.angelaxd.proyectosignalingo.ui.objetos.Texto
import com.angelaxd.proyectosignalingo.ui.objetos.Texto2

@Composable

fun PerfilScreen(navController: NavHostController, email: String){
    funScaffoldPerfil(navController, email)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldPerfil(navController: NavHostController, email: String){
    Scaffold (
        topBar = { FunTopBar(navController, "Perfil") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                BoxFun(email)
                //Text("Hola mundo!", )
            }

        }
    }

}

@Composable
fun BoxFun(email: String) {
    Box(modifier= Modifier
        .fillMaxWidth()
        .background(Color(0xC1D0B9F0))
        .height(400.dp)

    ){
        //Spacer(modifier =Modifier.width(100.dp))
        Imagen("https://static.vecteezy.com/system/resources/previews/000/597/915/original/sweet-color-blurred-background-set-pastel-color-design-vector.jpg", 10000000, 1000000);
        Column(modifier = Modifier.padding(top = 100.dp, bottom = 20.dp,start=130.dp)){//top = 315.dp, bottom = 2.dp,start=10.dp

            Imagen("https://www.leadsourcing.co.in/images/user.png", 350, 350);
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = "User Oyente123")
        }
    }
    FunCard(email)

}

@Composable
fun FunCard(email: String){
    Column {
        Card {
            Texto("Nombre:")
            Texto2("Phil Mongomery")
        }
        Spacer(modifier = Modifier.height(5.dp))
        Card {
            Texto("E-mail:")
            Texto2(email)
        }
    }
}