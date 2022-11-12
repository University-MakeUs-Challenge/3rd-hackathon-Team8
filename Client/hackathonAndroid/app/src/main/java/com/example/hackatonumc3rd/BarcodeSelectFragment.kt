package com.example.hackatonumc3rd

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.hackatonumc3rd.databinding.DialogBarcodeBinding

class BarcodeSelectFragment: Fragment() {
    lateinit var viewBinding: DialogBarcodeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogBarcodeBinding.inflate(layoutInflater)
        lateinit var select: String

        viewBinding.btnScan.setOnClickListener {
            viewBinding.btnScan.strokeColor = ColorStateList.valueOf(Color.rgb(255, 87, 51))
            select = "scan"
        }

        viewBinding.btnEnter.setOnClickListener {
            viewBinding.btnEnter.strokeColor = ColorStateList.valueOf(Color.rgb(255, 87, 51))
            select = "enter"
        }

        viewBinding.btnNext.setOnClickListener {
            if (select == "scan") {
                val result = "scan"
                // Use the Kotlin extension in the fragment-ktx artifact
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))
            }

            if (select == "enter") {
            val result = "enter"
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }
        }



        return viewBinding.root
    }
}