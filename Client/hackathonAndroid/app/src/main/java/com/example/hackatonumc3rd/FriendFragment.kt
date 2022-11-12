package com.example.hackatonumc3rd
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackatonumc3rd.databinding.FragmentFriendBinding
import com.example.hackatonumc3rd.databinding.FragmentMypageBinding

class FriendFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFriendBinding.inflate(layoutInflater).root
    }
}