package com.angelaxd.proyectosignalingo.ui.objetos

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.guardados.viewmodel.GuardadosViewmodel

@Composable
fun Imagen(link: String, width: Int, height: Int){

    AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(link)
        .transformations()
        .size(width,height)
        .build()
        , contentDescription = null)

}


@Composable
fun ImagenLogin(link: String){

    AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(link)
        .transformations()
        .build()
        , contentDescription = null)

}

@OptIn(ExperimentalMaterial3Api::class)
@Deprecated("Usar FunTopBar")
@Composable
fun FunTopBar(navController: NavController, texto: String){
    TopAppBar(
        colors= TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF6650a4),
            //containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,

            ),
        navigationIcon = {
            IconButton(onClick = { navController.navigate(route= AppScreens.MenuPrincipalScreen.route) })
            {
                Icon(
                    imageVector = Icons.Filled.Menu, contentDescription = "menu", modifier= Modifier.size(48.dp)
                )
            }
            Spacer(modifier = Modifier.width(50.dp))
        },

        title={ Text(text = texto, color = Color.White)}


    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FunBottomBar(navController: NavController){

    BottomAppBar(contentPadding = PaddingValues(start = 20.dp,end= 20.dp)) {
        IconButton(onClick = { navController.navigate(route= AppScreens.MenuPrincipalScreen.route) }) {
            Icon(Icons.Filled.Home, contentDescription = "Home", modifier= Modifier.size(48.dp))
        }
        Spacer(modifier = Modifier.width(50.dp))
        IconButton(onClick = { navController.navigate(route= AppScreens.GuardadosScreen.route) }) {
            Icon(Icons.Filled.BookmarkBorder, contentDescription = "guardados", modifier= Modifier.size(48.dp))
        }
        Spacer(modifier = Modifier.width(50.dp))
        IconButton(onClick = { navController.navigate(route= AppScreens.PerfilScreen.route) }) {
            Icon(Icons.Filled.AccountCircle, contentDescription = "profile", modifier= Modifier.size(48.dp))
        }
        Spacer(modifier = Modifier.width(50.dp))
        IconButton(onClick = { navController.navigate(route= AppScreens.QuienesSomosScreen.route) }) {
            Icon(Icons.Filled.Info, contentDescription = "Info", modifier= Modifier.size(48.dp))
        }
    }

}


@Composable
fun Texto(texto: String){

    Text(
        text = texto,
        modifier = Modifier
            //.fillMaxWidth()
            .padding(5.dp),
        //modifier = Modifier.padding()
        //modifier = Modifier.wrapContentHeight(),
        fontSize = 22.sp,
        //color = Color(0xFF6200EE),
        color = Color.White,
        fontWeight= FontWeight.Bold, //grosor del texto
        fontStyle = FontStyle.Normal, //estilo (normal, cursiva..)
        lineHeight = 10.sp, //altura de linea del texto
        overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
    )

}

@Composable
fun Texto2(texto: String){

    Text(
        text = texto,
        modifier = Modifier
            //.fillMaxWidth()
            .padding(10.dp),
        //modifier = Modifier.padding()
        //modifier = Modifier.wrapContentHeight(),
        fontSize = 18.sp,
        //color = Color(0xFF6200EE),
        color = Color.White,
        fontWeight= FontWeight.Normal, //grosor del texto
        fontStyle = FontStyle.Normal, //estilo (normal, cursiva..)
        lineHeight = 20.sp, //altura de linea del texto
        overflow = TextOverflow.Ellipsis //como se maneja el desbordamiento
    )

}

@Composable
fun Botones(navController: NavHostController, s:String){ // s es el parametro de que categoria se desea ver
    Column(modifier = Modifier.padding(start=80.dp)) {

        Spacer(modifier = Modifier.height(45.dp))
        //aqui se debe de mandar el parametro de item (s)
        Button( onClick =  { navController.navigate(route= AppScreens.ContenidoScreen.createRoute(s)){
            launchSingleTop = true
        } },
            modifier= Modifier
                .width(240.dp)
                .height(50.dp),
            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
        ) {
            Text(text = s)
        }

    }

}

@Composable
fun ListItemRow(item: String, navController: NavHostController) {
    val viewModelGuardados : GuardadosViewmodel = viewModel()
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.Transparent)
            .clickable {navController.navigate(route= AppScreens.MostrarVideoScreen.createRoute(item))  },


        ) {
        Icon( painter = painterResource(id = R.drawable.ic_icono), contentDescription = "")


        Text(text = item, Modifier.weight(4f).padding(start = 10.dp))

        IconButton(
            onClick = {
                viewModelGuardados.createGuardado(item){
                    Toast.makeText(context, context.getString(R.string.Guardado), Toast.LENGTH_SHORT).show()
                    navController.navigate(route= AppScreens.MenuPrincipalScreen.route)
                }
        },
            Modifier
                .size(30.dp)
                .padding(5.dp)
                .weight(1f),

        ) {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder, contentDescription = "Favorite", modifier= Modifier.size(48.dp)
            )
        }



    }
}