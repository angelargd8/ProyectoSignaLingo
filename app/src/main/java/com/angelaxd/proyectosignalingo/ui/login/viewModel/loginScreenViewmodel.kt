package com.angelaxd.proyectosignalingo.ui.login.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch



class loginScreenViewmodel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun SignInWithEmailAndPassword(email: String, password: String, home: ()->Unit)
    = viewModelScope.launch {

        try{
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if(it.isSuccessful){
                        Log.d("--------signalingo: ","logedo")
                        home()
                    }else{
                        //loading.value = false
                        Log.d("--------signalingo: ","error")
                    }
                }

        }catch (e: Exception){
            e.printStackTrace()
        }


    }


    fun createUserWithEmailAndPassword(email: String, password: String, home: ()->Unit){

        if (_loading.value == false){
            _loading.value= true
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (it.isSuccessful){
                        val displayName= it.result.user?.email?.split("@")?.get(0)
                        createUser(displayName)
                        Log.d("--------signalingo: ","creado")
                        home()
                    }else{
                        _loading.value= false
                        Log.d("--------signalingo: ","error")
                    }
                    _loading.value= false
                }

        }
    }


    private fun createUser(displayName: String?) {
        val userId = auth.currentUser?.uid
        val user = mutableMapOf<String, Any>()

        user["user_id"] = userId.toString()
        user["display_name"] = displayName.toString()

        //usar el dataclass
        /*val user = User(
            id = null,
            userId = userId.toString(),
            username = displayName.toString(),
            photoUrl = ""
        ).toMap()*/

        FirebaseFirestore.getInstance().collection("users")
            .document(userId.toString())
            .set(user)
            .addOnSuccessListener {
                Log.d("--------signalingo: ","creado")
            }.addOnFailureListener{
                Log.d("--------signalingo: ","error")

            }

    }

}