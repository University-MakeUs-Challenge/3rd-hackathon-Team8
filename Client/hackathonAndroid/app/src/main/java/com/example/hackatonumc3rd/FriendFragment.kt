package com.example.hackatonumc3rd
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackatonumc3rd.databinding.FragmentFriendBinding

class FriendFragment: Fragment() {
    lateinit var viewBinding: FragmentFriendBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentFriendBinding.inflate((layoutInflater))

        val dataList: ArrayList<FriendData> =arrayListOf()

        dataList.apply{
            add(FriendData("현재 월곡역 부근", "현재 모임명 솜솜이", "점수 10"))
            add(FriendData("현재 상월곡역 부근", "현재 모임명 som", "점수 20"))
            add(FriendData("현재 돌곶이역 부근", "현재 모임명 솜솜", "점수 30"))
        }
        val friendAdapter = FriendRVAdapter(dataList)

        viewBinding.recyclerView.adapter = friendAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        return viewBinding.root
    }

}