package com.angelaxd.proyectosignalingo.ui.MostrarVideo.View

import android.annotation.SuppressLint
import android.service.controls.ControlsProviderService
import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.MostrarVideo.ViewModel.VideosVM
import com.angelaxd.proyectosignalingo.ui.guardados.viewmodel.GuardadosViewmodel
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database


@Composable
fun MostrarVideoScreen(navController: NavHostController, string: String){
    funScaffoldVideo(navController,string)
}

private lateinit var database: DatabaseReference


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun funScaffoldVideo(navController: NavHostController, string: String) {

    database = Firebase.database.reference
    val url = condicion(navController, string)  // condicion de que valor se mando de parametro
    val VideosVM : VideosVM = viewModel()
    //val g= VideosVM.obtenerURL(dato = "Alimentos")
    Scaffold (
        topBar = { FunTopBar(navController, string) },
        bottomBar = { FunBottomBar(navController) }

    ){
        Box(){
            Column(
                modifier = Modifier.padding(top = 100.dp)
            ) {
                Card {
                    VideoPlayer(url)
                }


            }
        }

    }
}

@Composable
fun VideoPlayer(url:String){
    val sampleVideo = url
    val context = LocalContext.current
    val player = SimpleExoPlayer.Builder(context).build()
    val playerView = PlayerView(context)
    val mediaItem = MediaItem.fromUri(sampleVideo)
    val playWhenReady by rememberSaveable {
        mutableStateOf(true)
    }
    player.setMediaItem(mediaItem)
    playerView.player = player
    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = playWhenReady

    }
    AndroidView(factory = {
        playerView
    })
}




@Composable
fun condicion(navController: NavHostController, string:String): String{

    val context = LocalContext.current
    var dataa=""

    if (string == context.getString(R.string.Comer)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Leer.mp4"
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Empezar.mp4"
    }
    if (string == context.getString(R.string.entender)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Entender.mp4"
    }
    if (string == context.getString(R.string.extrañar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Esconder.mp4"
    }
    if (string == context.getString(R.string.fallar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Fallar.mp4"
    }
    if (string == context.getString(R.string.idear)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Fallar.mp4"
    }
    if (string == context.getString(R.string.inspirar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Inspirar.mp4"
    }
    if (string == context.getString(R.string.jugar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Jugar.mp4"
    }
    if (string == context.getString(R.string.leer)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Verbos/Leer.mp4"

        // animales
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Animales/abeja.mp4"
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Animales/animales.mp4"
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Animales/insectos.mp4"
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Animales/mosca.mp4"
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Animales/mosquito.mp4"
    }
    if (string == context.getString(R.string.empezar)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Animales/zancudo.mp4"
    }

    // lugares

    if (string == context.getString(R.string.belice)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/Belice.mp4"
    }
    if (string == context.getString(R.string.honduras)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/honduras.mp4"
    }
    if (string == context.getString(R.string.centroamerica)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/Centroamerica.mp4"
    }
    if (string == context.getString(R.string.guatemala)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/Guatemala.mp4"
    }
    if (string == context.getString(R.string.costarica)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/Costa%20Rica.mp4"
    }
    if (string == context.getString(R.string.elsalvador)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/El%20Salvador.mp4"
    }
    if (string == context.getString(R.string.panama)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/Panama.mp4"
    }
    if (string == context.getString(R.string.nicaragua)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Lugares/Nicaragua.mp4"

    }

    //calendario
    if (string == context.getString(R.string.lunes)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/Lunes.mp4"
    }
    if (string == context.getString(R.string.martes)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/martes.mp4"
    }
    if (string == context.getString(R.string.miercoles)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/miercoles.mp4"

    }
    if (string == context.getString(R.string.jueves )) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/Jueves.mp4"
    }
    if (string == context.getString(R.string.viernes)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/Viernes.mp4"
    }
    if (string == context.getString(R.string.sabado)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/Sabado.mp4"
    }
    if (string == context.getString(R.string.hora)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/Hora.mp4"
    }
    if (string == context.getString(R.string.atrasado)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/atrasado.mp4"
    }
    if (string == context.getString(R.string.tarde)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/tarde.mp4"
    }
    if (string == context.getString(R.string.temprano)) {

        dataa = "https://storage.googleapis.com/videos-signalingo/Calendario/temprano.mp4"
    }















    return dataa
}


