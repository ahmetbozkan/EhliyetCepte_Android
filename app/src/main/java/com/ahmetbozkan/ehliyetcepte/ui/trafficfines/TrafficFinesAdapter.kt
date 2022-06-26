package com.ahmetbozkan.ehliyetcepte.ui.trafficfines

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficFine
import com.ahmetbozkan.ehliyetcepte.databinding.RowTrafficFineItemBinding
import javax.inject.Inject

class TrafficFinesAdapter @Inject constructor() :
    ListAdapter<TrafficFine, TrafficFinesAdapter.TrafficFineViewHolder>(diffUtil) {

    class TrafficFineViewHolder(val binding: RowTrafficFineItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrafficFineViewHolder =
        TrafficFineViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_traffic_fine_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TrafficFineViewHolder, position: Int) {
        val currentItem = getItem(position)

        with(holder.binding) {
            model = currentItem
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<TrafficFine>() {
            override fun areItemsTheSame(oldItem: TrafficFine, newItem: TrafficFine): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: TrafficFine, newItem: TrafficFine): Boolean =
                oldItem == newItem
        }
    }


}