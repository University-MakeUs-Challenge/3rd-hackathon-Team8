package com.example.hackatonumc3rd

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.hackatonumc3rd.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        viewBinding.btnMap.setOnClickListener {
            val intent = Intent(context, MapActivity::class.java)
            startActivity(intent)
        }

        return viewBinding.root
    }
}