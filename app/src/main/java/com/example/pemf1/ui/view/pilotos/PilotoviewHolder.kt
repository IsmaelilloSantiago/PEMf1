package com.example.pemf1.ui.view.pilotos

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.pemf1.databinding.ItemPilotoBinding
import com.example.pemf1.model.pilotos.Piloto
import com.squareup.picasso.Picasso

class PilotoviewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemPilotoBinding.bind(view)

    fun llenarListaPilotos(piloto: Piloto, contexto: Context){
        binding.tvPiloto.text =piloto.name
        binding.tvpospiloto.text = "Puesto en el mundial: " + piloto.posicion
        Picasso.get().load(piloto.foto).into(binding.ivAvatar)
        binding.tvPuntos.text = "Puntos en el mundial: " + piloto.points +" puntos"

        binding.cardPiloto.setOnClickListener {
            Toast.makeText(contexto, binding.tvPiloto.text, Toast.LENGTH_SHORT).show()
        }
    }
    /*fun bind(image:String){
        Picasso.get().load(image).into(binding.ivDog)
    }*/

}