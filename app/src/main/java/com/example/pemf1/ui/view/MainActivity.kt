package com.example.pemf1.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.pemf1.databinding.ActivityMainBinding
import com.example.pemf1.model.pilotos.Piloto
import com.example.pemf1.ui.view.circuitos.CircuitoMasterActivity
import com.example.pemf1.ui.view.notification.NotificationActivity
import com.example.pemf1.ui.view.pilotos.PilotoAdapter
import com.example.pemf1.ui.view.pilotos.PilotosActivity

import com.example.pemf1.ui.viewmodel.PilotosViewModel

class MainActivity : AppCompatActivity() {

    private val pilotosViewModel : PilotosViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PilotoAdapter
    private val listaPilotos = mutableListOf<Piloto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verPilotos.setOnClickListener {
            val intent = Intent(this, PilotosActivity::class.java)
            startActivity(intent)
        }
        binding.verCircuitos.setOnClickListener{
            val intent = Intent(this, CircuitoMasterActivity::class.java)
            startActivity(intent)
        }
        binding.streamF1.setOnClickListener{
            val intent = Intent(this, StreamActivity::class.java)
            startActivity(intent)
        }

        binding.alarma.setOnClickListener{
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

    }


}