package com.example.pemf1.model.circuitos

import android.util.Log
import com.example.pemf1.core.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



class ServiceCircuito {
    private val retrofit = RetroFitHelper.getRetrofit()

    suspend fun getCircuitos(): Circuitos? {
        return withContext(Dispatchers.IO){
            val response = retrofit.create(APIServiceCircuito::class.java).getCircuitos()
            response.body()
        }
    }
}