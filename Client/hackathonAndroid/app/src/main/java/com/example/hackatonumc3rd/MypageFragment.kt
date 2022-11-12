package com.example.hackatonumc3rd
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hackatonumc3rd.databinding.FragmentHomeBinding
import com.example.hackatonumc3rd.databinding.FragmentMypageBinding

class MypageFragment: Fragment() {
    private lateinit var viewBinding: FragmentMypageBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentMypageBinding.inflate(layoutInflater)

        val ssb = SpannableStringBuilder("10승 | 3패")
        ssb.apply {
            setSpan(ForegroundColorSpan(Color.BLUE), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            setSpan(ForegroundColorSpan(Color.RED), 6, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }

        viewBinding.tvWinlose.text = ssb

        viewBinding.btnEditProfile.setOnClickListener {
            /* 프로필 수정 버튼 */
        }

        viewBinding.btnBadgeCf.setOnClickListener {
            /* 전체 뱃지 확인 버튼 */
        }


        return viewBinding.root
    }
}