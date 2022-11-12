package com.example.hackatonumc3rd

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackatonumc3rd.databinding.FragmentHomeBinding
import com.google.android.material.bottomsheet.BottomSheetDialog


class HomeFragment: Fragment() {
    private lateinit var viewBinding: FragmentHomeBinding
    private val mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewBinding = FragmentHomeBinding.inflate(layoutInflater)

        viewBinding.imgMap.setOnClickListener {
            val intent = Intent(context, MapActivity::class.java)
            startActivity(intent)
        }

        val dataList: ArrayList<Data> = arrayListOf()


        dataList.apply {
            add(Data("1","컴퓨터공학부", "90"))
            add(Data("2","컴퓨터공학부", "90"))
            add(Data("3","컴퓨터공학부", "90"))
            add(Data("4","컴퓨터공학부", "90"))
            add(Data("5","컴퓨터공학부", "90"))
        }

        val dataRVAdaptor = DataRVAdaptor(dataList)

        viewBinding.containerRanking.adapter = dataRVAdaptor
        viewBinding.containerRanking.layoutManager = LinearLayoutManager(context)
'b'
        return viewBinding.root

        viewBinding.imageView.setOnClickListener{
            val bottomSheet = bottomSheet()
            bottomSheet.show(childFragmentManager,bottomSheet.tag)

        }
    }
}

