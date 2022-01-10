package com.example.pemf1.model.circuitos



class RepositorioCircuito {
    private val api = ServiceCircuito()
    suspend fun getAllCircuitos(): Circuitos?{
        val response = api.getCircuitos()
        //Falta añadir base de datos
        //QuoteProvider.quotes = response
        return response
    }
}