package com.example.pemf1.model.pilotos

import com.google.gson.annotations.SerializedName

data class Piloto(@SerializedName("name")var name: String, @SerializedName("posicion")var posicion: String,@SerializedName("points")var points: String,@SerializedName("foto")var foto: String)
