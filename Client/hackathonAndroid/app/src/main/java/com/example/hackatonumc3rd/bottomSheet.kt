package com.example.hackatonumc3rd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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

        return viewBinding.root
    }
}