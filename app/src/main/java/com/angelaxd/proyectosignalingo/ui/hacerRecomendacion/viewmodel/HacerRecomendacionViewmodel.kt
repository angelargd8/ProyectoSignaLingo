package com.angelaxd.proyectosignalingo.ui.hacerRecomendacion.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore

class HacerRecomendacionViewmodel:ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun createRecomendacion(title: String?, description: String?, home: ()->Unit) {
        val userId = auth.currentUser?.uid
        val recommendation = mutableMapOf<String, Any>()

        recommendation["title"] = title.toString()
        recommendation["description"] = description.toString()

        FirebaseFirestore.getInstance().collection("recomendaciones")
            //.document(userId.toString())
            .add(recommendation)
            .addOnSuccessListener {
                Log.d("--------signalingo: ","se agregó recomendacion")
                home()

            }.addOnFailureListener{
                Log.d("--------signalingo: ","error")

            }

    }

}