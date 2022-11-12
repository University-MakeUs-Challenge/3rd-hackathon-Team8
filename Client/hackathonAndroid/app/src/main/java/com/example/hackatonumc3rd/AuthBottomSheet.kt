package com.example.hackatonumc3rd

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackatonumc3rd.databinding.DialogBarcodeBinding
import com.example.hackatonumc3rd.databinding.DialogBarcodeContainerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AuthBottomSheet(): BottomSheetDialogFragment() {
    lateinit var viewBinding: DialogBarcodeContainerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = DialogBarcodeContainerBinding.inflate(layoutInflater)

        childFragmentManager
            .beginTransaction()
            .replace(viewBinding.barcodeContainer.id, BarcodeSelectFragment())
            .commitAllowingStateLoss()

        childFragmentManager.setFragmentResultListener("requestKey", this) { requestKey, bundle ->
            val message = bundle.getString("bundleKey")

            if (message == "scan")
                childFragmentManager.beginTransaction().replace(viewBinding.barcodeContainer.id, BarcodeScanFragment()).commitAllowingStateLoss()

            if (message == "previous")
                childFragmentManager.beginTransaction().replace(viewBinding.barcodeContainer.id, BarcodeSelectFragment()).commitAllowingStateLoss()
        }

        return viewBinding.root
    }
}