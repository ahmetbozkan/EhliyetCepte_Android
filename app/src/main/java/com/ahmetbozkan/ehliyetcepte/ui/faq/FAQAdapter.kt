package com.ahmetbozkan.ehliyetcepte.ui.faq

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.FAQ
import com.ahmetbozkan.ehliyetcepte.databinding.RowFaqItemBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.gone
import com.ahmetbozkan.ehliyetcepte.util.extension.visible
import javax.inject.Inject

class FAQAdapter @Inject constructor() : ListAdapter<FAQ, FAQAdapter.FAQViewHolder>(diffUtil) {

    class FAQViewHolder(val binding: RowFaqItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FAQViewHolder =
        FAQViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_faq_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) {
        val currentItem = getItem(position)

        with(holder.binding) {
            faq = currentItem

            imgArrowExpand.setOnClickListener {
                if (tvAnswer.visibility == View.GONE) tvAnswer.visible()
                else tvAnswer.gone()
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<FAQ>() {
            override fun areItemsTheSame(oldItem: FAQ, newItem: FAQ): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: FAQ, newItem: FAQ): Boolean =
                oldItem == newItem
        }
    }


}