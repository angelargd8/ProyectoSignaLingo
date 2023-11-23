package com.angelaxd.proyectosignalingo.ui.perfil.view

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.angelaxd.proyectosignalingo.ui.objetos.Texto
import com.angelaxd.proyectosignalingo.ui.objetos.Texto2
import com.google.firebase.auth.FirebaseAuth

@Composable

fun PerfilScreen(navController: NavHostController){
    val context = LocalContext.current
    funScaffoldPerfil(navController,context)

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldPerfil(navController: NavHostController, context: Context){
    Scaffold (
        topBar = { FunTopBar(navController, context.getString(R.string.Perfil)) },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {

            Column {
                BoxFun(navController, context)
                //Text("Hola mundo!", )
            }

        }
    }

}

@Composable
fun BoxFun(navController: NavHostController, context: Context) {
    Box(modifier= Modifier
        .fillMaxWidth()
        .background(Color(0xC1D0B9F0))
        .height(400.dp)

    ){
        //Spacer(modifier =Modifier.width(100.dp))
        Imagen("https://i.imgur.com/tQp3omr.png", 1000000, 1000000);
        Column(modifier = Modifier.padding(top = 100.dp, bottom = 20.dp,start=130.dp)){//top = 315.dp, bottom = 2.dp,start=10.dp

            Imagen("https://www.leadsourcing.co.in/images/user.png", 350, 350);
            Spacer(modifier = Modifier.height(10.dp))
            val nombreUser = FirebaseAuth.getInstance().currentUser!!.email!!.substringBefore("@")
            Text(text = nombreUser,
                Modifier.padding(start= 45.dp)
                )
        }
    }
    FunCard(navController,context)

}

@Composable
fun FunCard(navController: NavHostController, context: Context){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(1.dp))
        Card(modifier = Modifier
            .padding(20.dp),
            colors = CardDefaults.cardColors(
                Color(0xFF6650a4)
            )) {
            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Texto(context.getString(R.string.Nombre))
                val nombreUser = FirebaseAuth.getInstance().currentUser!!.email!!.substringBefore("@")
                Texto2(nombreUser)
            }

        }
        Spacer(modifier = Modifier.height(1.dp))
        Card(modifier = Modifier
            .padding(20.dp),
            colors = CardDefaults.cardColors(
                Color(0xFF6650a4)
            )) {
            Row(modifier = Modifier
                .fillMaxWidth()
            ) {
                Texto(context.getString(R.string.Email))
                val userEmail= FirebaseAuth.getInstance().currentUser!!.email
                Texto2(userEmail!!)
                //FirebaseAuth.getInstance().currentUser!!.email.isNullOrEmpty()
            }

        }
        Spacer(modifier = Modifier.height(1.dp))
        Button( onClick =  {

            navController.navigate(route= AppScreens.LoginScreen.route)

        },
            modifier= Modifier
                .width(200.dp)
                .height(45.dp),
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
        ) {

            Text(text = context.getString(R.string.Cerrar))
        }
    }
}