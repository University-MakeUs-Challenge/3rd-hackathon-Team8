package com.example.hackatonumc3rd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hackatonumc3rd.databinding.FragmentChallengeBinding
import com.example.hackatonumc3rd.databinding.FragmentChallengeBottomBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChallengeBottomSheetFragment: BottomSheetDialogFragment() {
    private lateinit var viewBinding: FragmentChallengeBottomBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentChallengeBottomBinding.inflate(layoutInflater)
        return inflater.inflate(R.layout.fragment_challenge_bottom, container, false)
    }
}