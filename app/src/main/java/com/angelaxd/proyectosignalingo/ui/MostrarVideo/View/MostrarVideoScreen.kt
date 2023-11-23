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
                Text(text = VideosVM.obtenerDato("Alimentos", "aceite")["aceite"].toString())
                println("Hola")
                Log.d(TAG, "probanfo")

            }
        }

    }
}

@Composable
fun VideoPlayer(url:String){
    val sampleVideo = "https://storage.googleapis.com/videos-signalingo/Verbos/Empezar.mp4"
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
fun condicion(navController: NavHostController, string: String): String{

    val context = LocalContext.current
    var dataa=""

    if (string == context.getString(R.string.Comer)) {

        dataa = "https://www.youtube.com/watch?v=8ZY8p9YdDgQ"
    }


    return dataa
}


