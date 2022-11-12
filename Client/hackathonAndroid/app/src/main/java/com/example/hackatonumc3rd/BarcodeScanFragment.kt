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
import com.example.hackatonumc3rd.databinding.DialogBarcodeScanBinding

class BarcodeScanFragment : Fragment() {
    lateinit var viewBinding: DialogBarcodeScanBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogBarcodeScanBinding.inflate(layoutInflater)
        lateinit var msg: String

        viewBinding.btnPrevious.setOnClickListener {
            msg = "previous"
            setFragmentResult("requestKey", bundleOf("bundleKey" to msg))
        }

        viewBinding.btnNext.setOnClickListener {
            msg = "next"
            setFragmentResult("requestKey", bundleOf("bundleKey" to msg))
        }

        return viewBinding.root
    }
}