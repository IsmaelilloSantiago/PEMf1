package com.example.pemf1.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pemf1.R
import com.example.pemf1.databinding.ActivityStreamBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso

class StreamActivity : AppCompatActivity() {
    private lateinit var binding:ActivityStreamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStreamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.getReference("Circuito")
        val piloto1 = database.getReference("piloto1")
        val piloto2 = database.getReference("piloto2")
        val piloto3 = database.getReference("piloto3")
        val vueltaActual = database.getReference("vueltas")
        val vueltas = database.getReference("vueltasTotales")
        val url = database.getReference("url")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                binding.nombreCircuito.text = "Circuito: $value"

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })

        piloto1.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                binding.piloto3.text = "1.  $value"

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })
        piloto2.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                binding.piloto2.text = "2.  $value "

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })

        piloto3.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                binding.piloto1.text = "3.  $value "

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })

        vueltaActual.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                binding.vueltaActual.text = "Vuelta actual: $value"

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })

        vueltas.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                binding.vueltasTotales.text = "$value vueltas en total"

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })

        url.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                var value = dataSnapshot.getValue<String>()
                Log.e("TAG", "Value is: $value")
                Picasso.get().load(value).into(binding.imagenCircuito)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.e("TAG", "Failed to read value.", error.toException())
            }
        })





    }
}