package com.example.pemf1.model.pilotos

import com.example.pemf1.model.pilotos.Users
import retrofit2.Response
import retrofit2.http.GET

interface APIService {
    @GET("/609a8b0851cab0dfd44a")
    suspend fun getPilotos(): Response<Users>
}