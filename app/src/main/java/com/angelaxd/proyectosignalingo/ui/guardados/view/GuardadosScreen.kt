package com.angelaxd.proyectosignalingo.ui.guardados.view

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.items
import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.ui.objetos.FunBottomBar
import com.angelaxd.proyectosignalingo.ui.objetos.FunTopBar

@Composable
fun GuardadosScreen(navController: NavHostController){
    funScaffoldGuardados(navController)
}

data class Images(var img: Int, var txt1 : String)



@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun funScaffoldGuardados(navController: NavHostController){
    var saves =
        listOf(
            listOf(Images(R.drawable.ic_comunicarimg, "Comunicar"),Images(R.drawable.ic_enseniarimg, "Enseñar") ) ,
            listOf(Images(R.drawable.ic_comerimg, "Comer"),Images(R.drawable.ic_saludarimg, "Saludar") )
            ,listOf(Images(R.drawable.ic_comunicarimg, "Comunicar"),Images(R.drawable.ic_enseniarimg, "Enseñar") ) ,
            listOf(Images(R.drawable.ic_comerimg, "Comer"),Images(R.drawable.ic_saludarimg, "Saludar") )
            ,listOf(Images(R.drawable.ic_comunicarimg, "Comunicar"),Images(R.drawable.ic_enseniarimg, "Enseñar") ) ,
            listOf(Images(R.drawable.ic_comerimg, "Comer"),Images(R.drawable.ic_saludarimg, "Saludar") )

    )

    Scaffold (
        topBar = { FunTopBar(navController, "Guardados") },
        bottomBar = { FunBottomBar(navController) }

    ){ innerPadding ->
        LazyColumn(modifier = Modifier
            .padding(innerPadding),

        ) {

            items(saves) { save ->
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(10.dp)

                ) {
                    Cards(save[0], navController)
                    Cards(save[1], navController)
                }

            }
        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cards(  p: Images, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(30.dp)

    ) {
        Image(
            painter = painterResource(id = p.img),
            contentDescription = stringResource(id = R.string.s1),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(130.dp)
        )
        Text(
            text = p.txt1, fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Italic,

            )

    }
}



