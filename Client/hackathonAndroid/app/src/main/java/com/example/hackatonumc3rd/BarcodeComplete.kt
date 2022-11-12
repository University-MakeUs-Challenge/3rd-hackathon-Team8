package com.example.hackatonumc3rd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.hackatonumc3rd.databinding.DialogBarcodeCompleteBinding

class BarcodeComplete: Fragment() {
    lateinit var viewBinding: DialogBarcodeCompleteBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogBarcodeCompleteBinding.inflate(layoutInflater)
        lateinit var msg: String

        viewBinding.btnDone.setOnClickListener {
            msg = "done"
            setFragmentResult("requestKey", bundleOf("bundleKey" to msg))
        }

        return viewBinding.root
    }
}