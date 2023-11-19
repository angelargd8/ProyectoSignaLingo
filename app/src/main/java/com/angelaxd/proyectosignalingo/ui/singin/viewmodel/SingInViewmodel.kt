package com.angelaxd.proyectosignalingo.ui.singin.viewmodel
/*
import androidx.lifecycle.ViewModel
import com.angelaxd.proyectosignalingo.data.SignInResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Nota: esto ya no se uso
 * **/


class SingInViewmodel: ViewModel() {
    private val _state = MutableStateFlow(SingInState())
    val state = _state.asStateFlow()

    fun onSingResult(result: SignInResult){
        _state.update { it.copy(
            isSingInSuccessful = result.data != null,
            singInError = result.errorMessage
        ) }

    }

    fun resetState(){
        _state.update { SingInState() }
    }


}*/