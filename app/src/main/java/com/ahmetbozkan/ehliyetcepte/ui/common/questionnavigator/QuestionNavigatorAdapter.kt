package com.ahmetbozkan.ehliyetcepte.ui.common.questionnavigator

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.RowQuestionNavigatorItemBinding
import javax.inject.Inject

class QuestionNavigatorAdapter @Inject constructor() :
    ListAdapter<Question, QuestionNavigatorAdapter.QuestionNavigatorViewHolder>(
        diffUtil
    ) {

    class QuestionNavigatorViewHolder(val binding: RowQuestionNavigatorItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    var click: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionNavigatorViewHolder =
        QuestionNavigatorViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_question_navigator_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: QuestionNavigatorViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.binding.apply {
            tvIndex.text = (position.plus(1)).toString()

            root.backgroundTintList = when (currentItem.selectedOption) {
                Options.NONE -> {
                    ContextCompat.getColorStateList(root.context, android.R.color.transparent)
                }
                currentItem.correctOption -> {
                    ContextCompat.getColorStateList(root.context, R.color.teal_200)
                }
                else -> {
                    ContextCompat.getColorStateList(root.context, R.color.red_error)
                }
            }

            root.setOnClickListener {
                click?.invoke(position)
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