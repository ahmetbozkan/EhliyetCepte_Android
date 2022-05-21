package com.ahmetbozkan.ehliyetcepte.ui.common.examcategory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.databinding.RowExamCategoryItemBinding
import javax.inject.Inject

class ExamCategoryAdapter @Inject constructor() :
    ListAdapter<ExamCategory, ExamCategoryAdapter.ExamCategoryViewHolder>(diffUtil) {

    class ExamCategoryViewHolder(val binding: RowExamCategoryItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var click: ((ExamCategory) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamCategoryViewHolder =
        ExamCategoryViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_exam_category_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ExamCategoryViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.tvCategory.apply {
            text = currentItem.category.name

            setOnClickListener {
                click?.invoke(currentItem)
            }

            background = if (currentItem.isSelected) ContextCompat.getDrawable(
                context,
                R.color.orange_warning
            )
            else ContextCompat.getDrawable(context, R.color.white)
        }
    }

    fun onCategorySelected(category: ExamCategory) {
        val items = currentList.map {
            ExamCategory(it.id, it.category, false)
        }.apply {
            find { it.id == category.id }?.isSelected = true
        }

        submitList(items)
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<ExamCategory>() {
            override fun areItemsTheSame(oldItem: ExamCategory, newItem: ExamCategory): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: ExamCategory, newItem: ExamCategory): Boolean =
                oldItem == newItem
        }
    }
}