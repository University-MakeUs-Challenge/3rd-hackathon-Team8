package com.example.hackatonumc3rd

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackatonumc3rd.databinding.RankingItemDataBinding

class RankingDataRVAdapter(private val dataList: ArrayList<RankingData>): RecyclerView.Adapter<RankingDataRVAdapter.DataViewHolder>() {
    private val switchStatus = SparseBooleanArray()

    inner class DataViewHolder(private val viewBinding: RankingItemDataBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: RankingData) {
            viewBinding.tvRanking.text = data.ranking
            viewBinding.tvDepartment.text = data.department
            viewBinding.tvScore.text = data.score
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding =
            RankingItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])

    }

    override fun getItemCount(): Int = dataList.size

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }

    private lateinit var itemClickListener: OnItemClickListener
}

