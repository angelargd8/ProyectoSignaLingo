package com.angelaxd.proyectosignalingo.ui.guardados.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.angelaxd.proyectosignalingo.data.Guardado
import com.angelaxd.proyectosignalingo.data.GuardadosState
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class getGuardadosViewmodel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    val response: MutableState<GuardadosState> = mutableStateOf(GuardadosState.Empty)
    init {
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableListOf<Guardado>()
        val userId = auth.currentUser?.uid
        val db = FirebaseFirestore.getInstance()

        FirebaseFirestore.getInstance().collection("guardados").document(userId.toString()).get()
            .addOnSuccessListener { document ->
                if (document.exists()) {
                    val guardadosList = document.get("guardados") as List<Map<String, Any>>
                    for (guardadoMap in guardadosList) {
                        val guardadoItem = Guardado() // Asume que Guardado tiene un constructor sin argumentos
                        guardadoItem.title = guardadoMap["title"] as String
                        //guardadoItem.description = guardadoMap["description"] as String
                        tempList.add(guardadoItem)
                    }
                }
                //estado de exito
                response.value = GuardadosState.Success(tempList)
            }.addOnFailureListener { error ->
                //estado de error
                response.value = error.message?.let { GuardadosState.Failure(it) }!!
            }



    }


}