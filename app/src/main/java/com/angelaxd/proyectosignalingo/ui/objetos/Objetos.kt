package com.angelaxd.proyectosignalingo.ui.objetos

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun BoxFun(){
    Box(modifier= Modifier
        .fillMaxWidth()
        .fillMaxHeight()

    ) {
        Imagen("https://i.imgur.com/5cDS0Jv.png")
    }

}

@Composable
fun Imagen(link: String){

    AsyncImage(model = ImageRequest.Builder(LocalContext.current).data(link)
        .transformations()
        .build()
        , contentDescription = null)

}