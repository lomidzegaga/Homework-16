package com.example.homework_16.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.homework_16.databinding.CustomLayoutBinding
import com.example.homework_16.model.ResponseApi

class MainAdapter : PagingDataAdapter<ResponseApi,
        MainAdapter.MainViewHolder>(diffCallback) {


    inner class MainViewHolder(
        val binding: CustomLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<ResponseApi>() {
            override fun areItemsTheSame(oldItem: ResponseApi, newItem: ResponseApi): Boolean {
                return oldItem.page == newItem.page
            }

            override fun areContentsTheSame(oldItem: ResponseApi, newItem: ResponseApi): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            CustomLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currItem = getItem(position)

        holder.binding.apply {

            holder.itemView.apply {
                textView.text = "${currItem?.data}"
            }
        }

    }
}