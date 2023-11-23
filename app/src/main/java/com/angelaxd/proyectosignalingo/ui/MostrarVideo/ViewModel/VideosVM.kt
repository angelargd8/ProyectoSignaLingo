package com.angelaxd.proyectosignalingo.ui.MostrarVideo.ViewModel

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Source

class VideosVM: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)


    fun obtenerDato(d: String?) {
        val userId = auth.currentUser?.uid
        val url = mutableMapOf<String, Any>()

        url["title"] = d.toString()

        val db = FirebaseFirestore.getInstance()

        val docRef = db.collection("Contenido").document(userId.toString())
        //obtener el documento del usuario
        if (d != null) {
            db.collection("Contenido")
                .whereEqualTo(d, true)
                .get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        Log.d(TAG, "${document.id} => ${document.data}")
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents: ", exception)
                }
        }else{
            Log.e(TAG, "Error getting documents: ")
        }



    }
}
