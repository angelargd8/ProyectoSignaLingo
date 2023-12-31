package com.angelaxd.proyectosignalingo.ui.login.view

import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.angelaxd.proyectosignalingo.R
import com.angelaxd.proyectosignalingo.navigation.AppScreens
import com.angelaxd.proyectosignalingo.ui.login.viewModel.loginScreenViewmodel
import com.angelaxd.proyectosignalingo.ui.objetos.ImagenLogin

@Composable
fun LoginScreen(
    navController: NavHostController

) {

    val scrollState = rememberScrollState()
    val viewModelLogin: loginScreenViewmodel = viewModel()

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.verticalScroll(state= scrollState))
    {
        BoxFun(navController, viewModelLogin)
    }

}


@Composable
fun BoxFun(navController: NavHostController, viewModelLogin: loginScreenViewmodel){

    //variables y estados
    val context = LocalContext.current

    var email by remember { mutableStateOf("")}
    var isValidEmail by remember { mutableStateOf(false)}

    var contrasena by remember { mutableStateOf("")}
    var isValidPassword by remember { mutableStateOf(false)}

    var passwordVisible by remember { mutableStateOf(false)}

    //box

    Box(modifier= Modifier
        .fillMaxSize()


    ) {
            ImagenLogin("https://i.imgur.com/wbqhain.png")
            //Spacer(modifier = Modifier.height(1.dp))
            //FunButton(navController)
            //Column(modifier = Modifier.padding(top = 420.dp, bottom = 100.dp,start=120.dp)) {

            //}
            Column (modifier = Modifier.padding(top = 390.dp, bottom = 100.dp)){
                Row(){
                    Spacer(modifier = Modifier.width(50.dp))
                    Card (shape = RoundedCornerShape(10.dp), modifier = Modifier.wrapContentHeight(),
                        colors = CardDefaults.cardColors(
                            Color(0x88BFB1E7)
                        )
                    ){
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

                                viewModelLogin.SignInWithEmailAndPassword(email, contrasena){
                                    navController.navigate(route= AppScreens.MenuPrincipalScreen.route)
                                }


                                //navController.navigate(route= AppScreens.MenuPrincipalScreen.route)


                                               },
                                modifier= Modifier
                                    .width(200.dp)
                                    .height(45.dp),
                                colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
                            ) {
                                Text(text = context.getString(R.string.IniciarSesion))
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


                        navController.navigate(route= AppScreens.SignInScreen.route)

                                       },
                        modifier= Modifier
                            .width(200.dp)
                            .height(45.dp),
                        colors= ButtonDefaults.buttonColors(containerColor = Color(0xFF6650a4), contentColor = Color.White)
                    ) {
                        Text(text = context.getString(R.string.CrearCuenta))
                    }



                }



            }


    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FunEmail(email: String,
             emailChange: (String)->Unit,
             isValid: Boolean
){
    Row(modifier = Modifier
        //.fillMaxWidth()
        .wrapContentHeight()
        .padding(10.dp),
        horizontalArrangement = Arrangement.Center
        ) {
            //elementos
            //Spacer(modifier = Modifier.width(10.dp))
            OutlinedTextField(value = email,
                onValueChange = emailChange,
                label={ Text(text = "Email")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                maxLines = 1,
                singleLine= true,
                colors = if(isValid){
                    TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color.Green,
                        focusedBorderColor = Color.Green

                    )
                }else{
                    TextFieldDefaults.outlinedTextFieldColors(
                        focusedLabelColor = Color.Red,
                        focusedBorderColor = Color.Red
                    )

                }


            )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FunPassword(contrasena: String,
                passwordChange: (String)->Unit,
                passwordVisible: Boolean,
                passwordVisibleChange: ()->Unit,
                isValidPassword: Boolean
){
    Row(modifier = Modifier
        //.fillMaxWidth()
        .wrapContentHeight()
        .padding(10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        //elementos

        OutlinedTextField(value = contrasena,
            onValueChange = passwordChange,
            label={ Text(text = "Password")},
            maxLines = 1,
            singleLine= true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                  val image =  if (passwordVisible){
                      Icons.Filled.VisibilityOff

                  }else{
                      Icons.Filled.Visibility

                  }
                IconButton(onClick = passwordVisibleChange) {
                    Icon(
                        imageVector = image,
                        contentDescription = "ver contraseña"
                    )
                }
            },

            visualTransformation = if(passwordVisible){
                VisualTransformation.None
            }else{
                 PasswordVisualTransformation()
            },


            colors = if(isValidPassword){
                OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Green,
                    focusedLabelColor = Color.Green,
                )
            }else{
                OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Red,
                    focusedLabelColor = Color.Red,
                )

            }


        )
    }
}