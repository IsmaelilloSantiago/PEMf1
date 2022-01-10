package com.example.pemf1.model.circuitos

import com.google.gson.annotations.SerializedName

data class Circuit(@SerializedName("circuito")var circuito: String, @SerializedName("pais")var pais: String,@SerializedName("lat")var lat: String,@SerializedName("long")var long: String,@SerializedName("url")var url: String)
