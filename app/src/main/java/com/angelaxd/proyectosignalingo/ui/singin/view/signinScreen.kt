package com.angelaxd.proyectosignalingo.ui.singin.view

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.login.view.FunEmail
import com.angelaxd.proyectosignalingo.ui.login.view.FunPassword
import com.angelaxd.proyectosignalingo.ui.login.viewModel.loginScreenViewmodel
import com.angelaxd.proyectosignalingo.ui.objetos.ImagenLogin

@Composable
fun SignInScreen(navController: NavHostController) {

    val scrollState = rememberScrollState()
    val viewModelLogin: loginScreenViewmodel = viewModel()

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(state= scrollState))
    {
        BoxFun2(navController, viewModelLogin)
    }

}


@Composable
fun BoxFun2(navController: NavHostController, viewModelLogin: loginScreenViewmodel){

    //variables y estados
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var isValidEmail by remember { mutableStateOf(false) }

    var contrasena by remember { mutableStateOf("") }
    var isValidPassword by remember { mutableStateOf(false) }

    var passwordVisible by remember { mutableStateOf(false) }

    //box

    Box(modifier= Modifier
        .fillMaxSize()


    ) {
        ImagenLogin("https://i.imgur.com/wbqhain.png")

        //}
        Column (modifier = Modifier.padding(top = 390.dp, bottom = 100.dp)){
            Row(){
                Spacer(modifier = Modifier.width(50.dp))
                Card (shape = RoundedCornerShape(10.dp), modifier = Modifier.wrapContentHeight(),
                    colors = CardDefaults.cardColors(
                        Color(0x88BFB1E7)
                    )){
                    //entrys para poner la informacion
                    FunEmail(email = email,
                        emailChange = {
                            email = it
                            isValidEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
                        },
                        isValidEmail
                    )

                    //ingresar contraseña
                    FunPassword(contrasena= contrasena,
                        passwordChange={
                            contrasena= it
                            isValidPassword= contrasena.length>=6
                        },
                        passwordVisible = passwordVisible,
                        passwordVisibleChange= {passwordVisible=!passwordVisible},
                        isValidPassword = isValidPassword
                    )

                    Column(modifier = Modifier.padding(start=50.dp)) {
                        Button( onClick =  {

                            viewModelLogin.createUserWithEmailAndPassword(email, contrasena){
                                Toast.makeText(context, context.getString(R.string.CuentaCreada), Toast.LENGTH_SHORT).show()
                                navController.navigate(route= AppScreens.MenuPrincipalScreen.route)
                                //createUserWithEmailAndPassword
                            }

                            //navController.navigate(route= AppScreens.MenuPrincipalScreen.route)
                        },
                            modifier= Modifier
                                .width(200.dp)
                                .height(45.dp),
                            colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
                        ) {
                            Text(text = context.getString(R.string.Registrarse))
                        }
                        Spacer(modifier = Modifier.height(20.dp))
                    }



                }
            }
            Spacer(modifier = Modifier.height(20.dp))



            //botones
            Column(modifier = Modifier.padding(start=100.dp)) {
                //--botones para iniciar sesion y crear cuenta

                Spacer(modifier = Modifier.height(4.dp))
                //SignInBoton(navController)
                Button( onClick =  {


                    navController.navigate(route= AppScreens.LoginScreen.route)

                },
                    modifier= Modifier
                        .width(200.dp)
                        .height(45.dp),
                    colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
                ) {
                    Text(text = context.getString(R.string.YaTengoUnaCuenta))
                }



            }



        }


    }

}
