package com.angelaxd.proyectosignalingo.navigation

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){

    val scale= remember{
        androidx.compose.animation.core.Animatable(0f)
    }

    LaunchedEffect(key1 = true){
        scale.animateTo(
            targetValue = 0.9f,
            animationSpec = tween(durationMillis = 500,
                easing = {
                    OvershootInterpolator(8f)
                        .getInterpolation(it)
                }
            ),
        )
        delay(500L)

        if(FirebaseAuth.getInstance().currentUser!!.email.isNullOrEmpty()){
        navController.navigate(route= AppScreens.LoginScreen.route)
        }else{
        navController.navigate(route= AppScreens.MenuPrincipalScreen.route){
            popUpTo(AppScreens.SplashScreen.route){
                inclusive = true
            }
        }

    }

        //navController.navigate(AppScreens.LoginScreen.route)

    }
    val color = Color(0xFF9C27B0)
    //val color = MaterialTheme.colors.primary
    Surface(modifier = Modifier
        .padding(16.dp)
        .size(330.dp)
        .scale(scale.value),
        shape= CircleShape,
        color = Color.White,
        border = BorderStroke(width=2.dp, color = color)
    ) {
        Column(modifier = Modifier.padding(1.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){
            Text(text ="Singalingo...",
                style = MaterialTheme.typography.titleLarge,
                color = color.copy(alpha = 0.5f),
                fontWeight= FontWeight.Bold
                )
            Spacer(modifier=Modifier.height(15.dp))
        }

    }


}