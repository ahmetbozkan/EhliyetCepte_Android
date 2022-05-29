package com.ahmetbozkan.ehliyetcepte.ui.vehiclegauges

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.databinding.RowVehicleGaugeItemBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.loadUrl
import javax.inject.Inject

class VehicleGaugesAdapter @Inject constructor() :
    ListAdapter<VehicleGauge, VehicleGaugesAdapter.VehicleGaugesViewHolder>(diffUtil) {

    class VehicleGaugesViewHolder(val binding: RowVehicleGaugeItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var click: ((VehicleGauge) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleGaugesViewHolder =
        VehicleGaugesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_vehicle_gauge_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: VehicleGaugesViewHolder, position: Int) {
        val currentItem = getItem(position)

        with(holder.binding) {
            imgVehicleGauge.loadUrl(currentItem.imageUrl)

            root.setOnClickListener {
                click?.invoke(currentItem)
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<VehicleGauge>() {
            override fun areItemsTheSame(oldItem: VehicleGauge, newItem: VehicleGauge): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: VehicleGauge, newItem: VehicleGauge): Boolean =
                oldItem == newItem
        }
    }

}