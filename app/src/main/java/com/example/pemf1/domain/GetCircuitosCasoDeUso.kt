package com.example.pemf1.domain

import com.example.pemf1.model.circuitos.Circuitos
import com.example.pemf1.model.circuitos.RepositorioCircuito


class GetCircuitosCasoDeUso {
    private val repository = RepositorioCircuito()

    suspend operator fun invoke(): Circuitos? = repository.getAllCircuitos()
}