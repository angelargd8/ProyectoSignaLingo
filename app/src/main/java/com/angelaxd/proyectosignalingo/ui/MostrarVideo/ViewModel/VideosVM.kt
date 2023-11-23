package com.angelaxd.proyectosignalingo.ui.MostrarVideo.ViewModel

import android.service.controls.ControlsProviderService.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore


class VideosVM: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)


    fun obtenerDato(titulo: String, senia:String): MutableMap<String, Any> {
        val userId = auth.currentUser?.uid
        val url = mutableMapOf<String, Any>()

       // url["title"] = d.toString()

        val db = FirebaseFirestore.getInstance()
        println("Funcion entrada")
        db.collection("Contenido")
            .whereEqualTo(titulo, true)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    println("${document.id} => ${document.data}")
                    url.put(document.id,document.data)
                }
            }
            .addOnFailureListener { exception ->
                println("nop")
                Log.w(TAG, "Error getting documents: ", exception)
            }


        return url



    }
}
