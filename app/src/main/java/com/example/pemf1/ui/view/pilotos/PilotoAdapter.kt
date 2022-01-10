package com.example.pemf1.ui.view.pilotos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pemf1.R
import com.example.pemf1.model.pilotos.Piloto

class PilotoAdapter (private val nombres: List<Piloto>, private val contexto: Context): RecyclerView.Adapter<PilotoviewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PilotoviewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PilotoviewHolder(layoutInflater.inflate(R.layout.item_piloto, parent, false))
    }

    override fun onBindViewHolder(holder: PilotoviewHolder, position: Int) {
        val item = nombres[position]
        holder.llenarListaPilotos(item,contexto)

    }

    override fun getItemCount(): Int = nombres.size

}