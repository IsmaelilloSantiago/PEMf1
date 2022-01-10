package com.example.pemf1.model.pilotos

import com.example.pemf1.core.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Service {
        private val retrofit = RetroFitHelper.getRetrofit()

        suspend fun getPilotos(): Users? {
                return withContext(Dispatchers.IO){
                    val response = retrofit.create(APIService::class.java).getPilotos()
                    response.body()
                }

        }
}