package com.ahmetbozkan.ehliyetcepte.ui.result

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.RowResultItemBinding
import javax.inject.Inject

class ResultAdapter @Inject constructor() :
    ListAdapter<Question, ResultAdapter.ResultViewHolder>(diffUtil) {

    class ResultViewHolder(val binding: RowResultItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var click: ((Question) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder =
        ResultViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_result_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvQuestionNo.text = "${position + 1}."
            question = currentItem

            llRoot.background = if (currentItem.selectedOption != currentItem.correctOption)
                ContextCompat.getDrawable(llRoot.context, R.color.orange_warning)
            else
                ContextCompat.getDrawable(llRoot.context, R.color.teal_200)

            tvDisplayQuestion.setOnClickListener {
                click?.invoke(currentItem)
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Question>() {
            override fun areItemsTheSame(
                oldItem: Question,
                newItem: Question
            ): Boolean = oldItem.questionId == newItem.questionId

            override fun areContentsTheSame(
                oldItem: Question,
                newItem: Question
            ): Boolean = oldItem == newItem

        }
    }

}