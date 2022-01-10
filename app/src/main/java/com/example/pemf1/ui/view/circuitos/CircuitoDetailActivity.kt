package com.example.pemf1.ui.view.circuitos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pemf1.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class CircuitoDetailActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var map:GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circuito_detail)
        createFragment()
    }

    private fun createFragment() {
        val mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap:GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker() {
        val coordenadas = LatLng(intent.getDoubleExtra("lat",0.0),intent.getDoubleExtra("long",0.0))
        val marca : MarkerOptions = MarkerOptions().position(coordenadas).title(intent.getStringExtra("nombre"))
        map.addMarker(marca)
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(coordenadas,15f),4000,null)
    }
}

