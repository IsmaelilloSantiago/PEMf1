package com.example.pemf1.model.circuitos


import retrofit2.Response
import retrofit2.http.GET

interface APIServiceCircuito {
    @GET("/609a8b0851cab0dfd44a")
    suspend fun getCircuitos(): Response<Circuitos>
}