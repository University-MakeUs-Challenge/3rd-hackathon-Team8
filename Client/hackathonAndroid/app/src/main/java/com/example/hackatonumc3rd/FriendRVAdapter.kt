package com.example.hackatonumc3rd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackatonumc3rd.databinding.RecylerviewItemBinding


class FriendRVAdapter(val mFriendList: ArrayList<FriendData> =arrayListOf()) : RecyclerView.Adapter<FriendRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = RecylerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mFriendList!![holder.adapterPosition])
    }

    /*
    fun setFriendList(list: ArrayList<FriendData>?) {
        mFriendList = list
        notifyDataSetChanged()
    }*/

    override fun getItemCount(): Int {
        return mFriendList.size
    }

    inner class ViewHolder(private val viewBinding: RecylerviewItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {
        fun bind(data: FriendData) {
            viewBinding.txtStation.text = data.station
            viewBinding.txtName.text = data.name
            viewBinding.txtScore.text = data.score
        }

    }
}