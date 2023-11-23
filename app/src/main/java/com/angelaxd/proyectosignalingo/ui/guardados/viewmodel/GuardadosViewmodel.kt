package com.angelaxd.proyectosignalingo.ui.guardados.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class GuardadosViewmodel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)


    fun createGuardado(title: String?, home: () -> Unit) {
        val userId = auth.currentUser?.uid
        val guardado = mutableMapOf<String, Any>()

        guardado["title"] = title.toString()
        //guardado["description"] = description.toString()

        val db = FirebaseFirestore.getInstance()

        //obtener el documento del usuario
        db.collection("guardados").document(userId.toString()).get()
            .addOnSuccessListener { document ->
                var guardadosList = mutableListOf<Map<String, Any>>() //lista de guardados

                if (document.exists()) {
                    guardadosList = document.get("guardados") as MutableList<Map<String, Any>>
                }
                guardadosList.add(guardado)

                //actualizar el documento del usuario

                db.collection("guardados").document(userId.toString())
                    .set(mapOf("guardados" to guardadosList)
                ).addOnSuccessListener {
                    //home()
                    Log.d("--------signalingo: ","se agrego guardado")
                }.addOnFailureListener{
                    Log.d("--------signalingo: ","error")
                }



            }


    }


}
