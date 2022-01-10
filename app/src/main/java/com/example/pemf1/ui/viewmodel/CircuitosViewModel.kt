package com.example.pemf1.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemf1.domain.GetCircuitosCasoDeUso
import com.example.pemf1.model.circuitos.Circuit

import com.example.pemf1.model.circuitos.Circuitos
import com.example.pemf1.model.pilotos.Piloto
import kotlinx.coroutines.launch


class CircuitosViewModel : ViewModel() {

    var circuitoModel = MutableLiveData<Circuitos>()
    val getCircuitosCasoDeUso = GetCircuitosCasoDeUso()
    var isLoading = MutableLiveData<Boolean>()


    fun onCreate(){
        viewModelScope.launch {
            val result = getCircuitosCasoDeUso
            isLoading.postValue(true)

            Log.e("aver",result.invoke()?.Circuitos?.get(0)?.pais + "")

            if(result != null){
                circuitoModel.postValue(result.invoke())
                isLoading.postValue(false)
            }
        }
    }
}