package com.example.pemf1.ui.view.circuitos


import android.content.Context
import android.content.Intent
import android.view.View

import androidx.recyclerview.widget.RecyclerView
import com.example.pemf1.databinding.ItemCircuitoBinding
import com.example.pemf1.model.circuitos.Circuit
import com.squareup.picasso.Picasso

class CircuitosViewHolder (view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemCircuitoBinding.bind(view)

    fun llenarListaCircuitos(circuito:Circuit,context: Context){
        binding.tvCircuito.text = circuito.circuito
        binding.tvPais.text = circuito.pais
        Picasso.get().load(circuito.url).into(binding.ivCircuito)

        binding.cardCircuito.setOnClickListener{
            val intent = Intent(context, CircuitoDetailActivity::class.java)
            intent.putExtra("lat",circuito.lat.toDouble())
            intent.putExtra("long",circuito.long.toDouble())
            intent.putExtra("nombre",circuito.circuito)
            context.startActivity(intent)
        }
    }

}