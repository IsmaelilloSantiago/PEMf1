package com.example.pemf1.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pemf1.domain.GetPilotosCasoDeUso
import com.example.pemf1.model.pilotos.Users
import kotlinx.coroutines.launch

class PilotosViewModel: ViewModel() {

    var usersModel = MutableLiveData<Users>()
    val getPilotosCasoDeUso = GetPilotosCasoDeUso()
    var isLoading = MutableLiveData<Boolean>()

    fun onCreate(){
        viewModelScope.launch {
            val result = getPilotosCasoDeUso
            isLoading.postValue(true)

            //Log.e("aver",result.invoke()?.Users?.get(2)?.name + "")

            if(result != null){
                usersModel.postValue(result.invoke())
                isLoading.postValue(false)
            }
        }
    }
}