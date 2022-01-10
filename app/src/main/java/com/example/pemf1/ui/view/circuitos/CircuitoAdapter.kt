package com.example.pemf1.ui.view.circuitos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pemf1.R
import com.example.pemf1.model.circuitos.Circuit


class CircuitoAdapter(private val circuitos: List<Circuit>, private val contexto: Context) : RecyclerView.Adapter<CircuitosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CircuitosViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CircuitosViewHolder(layoutInflater.inflate(R.layout.item_circuito,parent,false))
    }

    override fun onBindViewHolder(holder: CircuitosViewHolder, position: Int) {
        val item = circuitos[position]
        holder.llenarListaCircuitos(item,contexto)
    }

    override fun getItemCount(): Int = circuitos.size

}