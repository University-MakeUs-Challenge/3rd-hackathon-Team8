package com.example.hackatonumc3rd

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.hackatonumc3rd.databinding.DialogNewGroupBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class bottomSheet : BottomSheetDialogFragment() {
    private lateinit var viewBinding: DialogNewGroupBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogNewGroupBinding.inflate(layoutInflater)

        viewBinding.btnGroupNext.setOnClickListener {
            val result = "go2"
            // Use the Kotlin extension in the fragment-ktx artifact
            setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        }

        return viewBinding.root
    }
}