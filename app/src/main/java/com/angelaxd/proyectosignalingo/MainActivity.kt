package com.angelaxd.proyectosignalingo

//import com.angelaxd.proyectosignalingo.ui.singin.repository.GoogleAuthClient
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.angelaxd.proyectosignalingo.navigation.AppNavigation
import com.angelaxd.proyectosignalingo.ui.theme.ProyectoSignaLingoTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoSignaLingoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //lifecycleScope
                    AppNavigation()
                }
            }
        }
    }
}
