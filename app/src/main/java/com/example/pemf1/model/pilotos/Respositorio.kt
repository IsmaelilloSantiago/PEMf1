package com.example.pemf1.model.pilotos

class Respositorio {
    private val api = Service()
    suspend fun getAllPilotos(): Users?{
        val response = api.getPilotos()
        //Falta añadir base de datos
        //QuoteProvider.quotes = response
        return response
    }
}