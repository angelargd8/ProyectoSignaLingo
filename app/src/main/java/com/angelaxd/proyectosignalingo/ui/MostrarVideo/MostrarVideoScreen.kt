package com.angelaxd.proyectosignalingo.ui.MostrarVideo

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.google.firebase.firestore.firestore


@Composable
fun MostrarVideoScreen(navController: NavHostController, string: String){
    funScaffoldVideo(navController,string)
}

private lateinit var database: DatabaseReference

@Composable
fun obtenerDatos(id:String){
    database = Firebase.database.reference
    database.child("Contenido").child(id).get().addOnSuccessListener {
        Log.i("firebase", "Got value ${it.value}")
    }.addOnFailureListener{
        Log.e("firebase", "Error getting data", it)
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun funScaffoldVideo(navController: NavHostController, string: String) {

    database = Firebase.database.reference
    val url = condicion(navController, string)  // condicion de que valor se mando de parametro


    Scaffold (
        topBar = { FunTopBar(navController, string) },
        bottomBar = { FunBottomBar(navController) }

    ){
        Box(){
            Column(
                modifier = Modifier.padding(top = 100.dp)
            ) {
                Card(){
                   // VideoPlayer(url)
                    obtenerDatos("Alimentos")
                }

            }
        }

    }
}

@Composable
fun VideoPlayer(url:String){
    val sampleVideo = "https://storage.cloud.google.com/videos-signalingo/WhatsApp%20Video%202023-11-22%20at%207.15.45%E2%80%AFPM.mp4"
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

