package com.ahmetbozkan.ehliyetcepte.ui.cityplates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.CityPlate
import com.ahmetbozkan.ehliyetcepte.databinding.RowCityPlateItemBinding
import javax.inject.Inject

class CityPlatesAdapter @Inject constructor() :
    ListAdapter<CityPlate, CityPlatesAdapter.CityPlatesViewHolder>(diffUtil) {

    class CityPlatesViewHolder(val binding: RowCityPlateItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityPlatesViewHolder =
        CityPlatesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_city_plate_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CityPlatesViewHolder, position: Int) {
        val currentItem = getItem(position)

        with(holder.binding) {
            plate = currentItem
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<CityPlate>() {
            override fun areItemsTheSame(oldItem: CityPlate, newItem: CityPlate): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: CityPlate, newItem: CityPlate): Boolean =
                oldItem == newItem
        }
    }

}