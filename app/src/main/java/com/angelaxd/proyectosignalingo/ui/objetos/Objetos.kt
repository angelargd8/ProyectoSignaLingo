package com.angelaxd.proyectosignalingo.ui.objetos

import android.health.connect.datatypes.HeightRecord
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Preview
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.angelaxd.proyectosignalingo.navigation.AppScreens

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
@Composable
fun FunTopBar(navController: NavController, texto: String){
    TopAppBar(

        colors= TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
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

        title={ Text(text = texto)}


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