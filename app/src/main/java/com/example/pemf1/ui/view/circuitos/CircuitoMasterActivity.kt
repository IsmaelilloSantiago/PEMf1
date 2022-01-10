package com.example.pemf1.ui.view.circuitos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pemf1.databinding.ActivityCircuitoMasterBinding
import com.example.pemf1.model.circuitos.Circuit
import com.example.pemf1.ui.viewmodel.CircuitosViewModel

//https://www.npoint.io/docs/609a8b0851cab0dfd44a

class CircuitoMasterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCircuitoMasterBinding
    private val circuitosViewModel: CircuitosViewModel by viewModels()
    private val listaCircuito = mutableListOf<Circuit>()
    private lateinit var adapter: CircuitoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCircuitoMasterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            Log.e("On create", "si")
            circuitosViewModel.onCreate()
        }

        circuitosViewModel.circuitoModel.observe(this, Observer {
            circuitosViewModel.circuitoModel.value?.let {
                it -> listaCircuito.addAll(it.Circuitos)
            }
            Log.e("circuitos",listaCircuito.toString())
            initRecyclerView()
        })


        circuitosViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

    }

    private fun initRecyclerView() {
        adapter = CircuitoAdapter(listaCircuito,this)
        binding.rvCircuitos.layoutManager = LinearLayoutManager(this)
        binding.rvCircuitos.adapter= adapter
    }
}