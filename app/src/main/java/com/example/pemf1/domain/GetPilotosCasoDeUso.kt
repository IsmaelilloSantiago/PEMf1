package com.example.pemf1.domain

import com.example.pemf1.model.pilotos.Respositorio
import com.example.pemf1.model.pilotos.Users

class GetPilotosCasoDeUso {
    private val repository = Respositorio()

    suspend operator fun invoke(): Users? = repository.getAllPilotos()
}