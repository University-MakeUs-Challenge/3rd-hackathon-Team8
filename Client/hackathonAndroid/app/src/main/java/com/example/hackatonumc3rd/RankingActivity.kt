package com.example.hackatonumc3rd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hackatonumc3rd.databinding.ActivityRankingBinding

class RankingActivity :AppCompatActivity() {

    private lateinit var viewBinding: ActivityRankingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityRankingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val dataList: ArrayList<RankingData> = arrayListOf()

        dataList.apply {
            add(RankingData("1", "컴퓨터공학과", "100"))
            add(RankingData("2", "컴퓨터공학과", "97"))
            add(RankingData("3", "컴퓨터공학과", "89"))
            add(RankingData("4", "컴퓨터공학과", "80"))
            add(RankingData("5", "컴퓨터공학과", "70"))
            add(RankingData("6", "컴퓨터공학과", "65"))
            add(RankingData("7", "컴퓨터공학과", "50"))
        }
        val dataRVadapter = RankingDataRVAdapter(dataList)

        viewBinding.rvRankingData.adapter = dataRVadapter
        viewBinding.rvRankingData.layoutManager = LinearLayoutManager(this)

    }
}