package com.example.pemf1.ui.view.pilotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pemf1.databinding.ActivityPilotosBinding
import com.example.pemf1.model.pilotos.Piloto
import com.example.pemf1.ui.viewmodel.PilotosViewModel

class PilotosActivity : AppCompatActivity() {

    private val pilotosViewModel : PilotosViewModel by viewModels()
    private lateinit var binding: ActivityPilotosBinding
    private lateinit var adapter: PilotoAdapter
    private val listaPilotos = mutableListOf<Piloto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPilotosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            Log.e("On create", "si")
            pilotosViewModel.onCreate()
        }



        pilotosViewModel.usersModel.observe(this, Observer{
            //binding.tvPrueba.text = it.Users.get(0).name
            Log.e("json", pilotosViewModel.usersModel.value?.Users.toString())

            pilotosViewModel.usersModel.value?.let { it1 -> listaPilotos.addAll(it1.Users) }

            Log.e("listaPilotos", listaPilotos.toString())
            initRecyclerView()
        })

        pilotosViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })
    }

    private fun initRecyclerView() {
        adapter = PilotoAdapter(listaPilotos,this)
        binding.rvPilotos.layoutManager = LinearLayoutManager(this)
        binding.rvPilotos.adapter= adapter
    }

}