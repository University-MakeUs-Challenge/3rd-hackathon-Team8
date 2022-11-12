package com.example.hackatonumc3rd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackatonumc3rd.databinding.ItemRankingBinding

class DataRVAdaptor (private val dataList: ArrayList<Data>): RecyclerView.Adapter<DataRVAdaptor.DataViewHolder>() {
    inner class DataViewHolder(private val viewBinding: ItemRankingBinding) :
        RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: Data) = with(viewBinding) {
            tvRank.text = data.rank
            tvDepart.text = data.depart
            tvScore.text = data.score

            itemView.setOnClickListener {

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val viewBinding = ItemRankingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size

}