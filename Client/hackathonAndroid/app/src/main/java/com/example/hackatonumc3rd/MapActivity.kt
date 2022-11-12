package com.example.hackatonumc3rd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hackatonumc3rd.databinding.ActivityMapBinding
import net.daum.mf.map.api.MapView

class MapActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMapBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        viewBinding = ActivityMapBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)

        val mapView = MapView(this)
        viewBinding.mapView.addView(mapView)
    }
}
