package com.example.hackatonumc3rd

import com.example.hackatonumc3rd.databinding.FragmentHome2Binding

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


class HomeFragment2: Fragment() {
    private lateinit var viewBinding: FragmentHome2Binding
    private val mLayoutManager: RecyclerView.LayoutManager? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bottomSheet = AuthBottomSheet()

        viewBinding = FragmentHome2Binding.inflate(layoutInflater)

        viewBinding.btnAuth.setOnClickListener {
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
        }

        childFragmentManager.setFragmentResultListener("requestKey", this) { requestKey, bundle ->
            val message = bundle.getString("bundleKey")

            if (message == "done")
                bottomSheet.dismiss()
        }

        viewBinding.imgMap.setOnClickListener {
            val intent = Intent(context, MapActivity::class.java)
            startActivity(intent)
        }

        val dataList_school: ArrayList<Data> = arrayListOf()
        val dataList_depart: ArrayList<Data> = arrayListOf()
        val dataList_person: ArrayList<Data> = arrayListOf()
        val dataList_class: ArrayList<Data> = arrayListOf()


        dataList_school.apply {
            add(Data("1","동국대", "95"))
            add(Data("2","동덕여대", "90"))
            add(Data("3","서울여대", "90"))
            add(Data("4","숙명여대", "90"))

        }
        dataList_depart.apply {
            add(Data("1","컴퓨터공학부", "90"))
            add(Data("2","컴퓨터공학부", "90"))
            add(Data("3","컴퓨터공학부", "90"))
        }
        dataList_person.apply {
            add(Data("1","샐리", "80"))
            add(Data("2","맨디", "90"))
            add(Data("3","제이", "90"))
        }
        dataList_class.apply {
            add(Data("1","UMC Android", "100"))
            add(Data("2","UMC Design", "90"))
            add(Data("3","UMC Server", "90"))
        }

        val dataRVAdaptor_school = DataRVAdaptor(dataList_school)
        val dataRVAdaptor_dapart = DataRVAdaptor(dataList_depart)
        val dataRVAdaptor_person = DataRVAdaptor(dataList_person)
        val dataRVAdaptor_class = DataRVAdaptor(dataList_class)

        viewBinding.btnSchool.setOnClickListener {
            viewBinding.containerRanking.adapter = dataRVAdaptor_school
            viewBinding.containerRanking.layoutManager = LinearLayoutManager(context)
        }
        viewBinding.btnDepart2.setOnClickListener {
            viewBinding.containerRanking.adapter = dataRVAdaptor_dapart
            viewBinding.containerRanking.layoutManager = LinearLayoutManager(context)
        }
        viewBinding.btnPerson.setOnClickListener {
            viewBinding.containerRanking.adapter = dataRVAdaptor_person
            viewBinding.containerRanking.layoutManager = LinearLayoutManager(context)
        }
        viewBinding.btnClass.setOnClickListener {
            viewBinding.containerRanking.adapter = dataRVAdaptor_class
            viewBinding.containerRanking.layoutManager = LinearLayoutManager(context)
        }

        return viewBinding.root
    }
}

