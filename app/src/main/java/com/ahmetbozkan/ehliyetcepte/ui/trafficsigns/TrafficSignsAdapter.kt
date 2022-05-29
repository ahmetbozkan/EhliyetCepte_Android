package com.ahmetbozkan.ehliyetcepte.ui.trafficsigns

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.databinding.RowVehicleGaugeItemBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.loadUrl
import javax.inject.Inject

class TrafficSignsAdapter @Inject constructor() :
    ListAdapter<TrafficSign, TrafficSignsAdapter.TrafficSignsViewHolder>(diffUtil) {

    class TrafficSignsViewHolder(val binding: RowVehicleGaugeItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var click: ((TrafficSign) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrafficSignsViewHolder =
        TrafficSignsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_vehicle_gauge_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TrafficSignsViewHolder, position: Int) {
        val currentItem = getItem(position)

        with(holder.binding) {
            imgVehicleGauge.loadUrl(currentItem.imageUrl)

            root.setOnClickListener {
                click?.invoke(currentItem)
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<TrafficSign>() {
            override fun areItemsTheSame(oldItem: TrafficSign, newItem: TrafficSign): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: TrafficSign, newItem: TrafficSign): Boolean =
                oldItem == newItem
        }
    }

}