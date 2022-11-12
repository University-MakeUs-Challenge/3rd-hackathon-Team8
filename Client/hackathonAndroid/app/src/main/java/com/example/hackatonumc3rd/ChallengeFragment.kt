package com.example.hackatonumc3rd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackatonumc3rd.databinding.FragmentChallengeBinding

class ChallengeFragment: Fragment() {
    private lateinit var viewBinding: FragmentChallengeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentChallengeBinding.inflate(layoutInflater)




        return FragmentChallengeBinding.inflate(layoutInflater).root
    }
}