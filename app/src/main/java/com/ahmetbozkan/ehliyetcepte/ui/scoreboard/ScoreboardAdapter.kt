package com.ahmetbozkan.ehliyetcepte.ui.scoreboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.databinding.RowScoreboardItemBinding
import javax.inject.Inject

class ScoreboardAdapter @Inject constructor() :
    ListAdapter<ExamWithQuestionsAndResult, ScoreboardAdapter.ScoreboardViewHolder>(
        diffUtil
    ) {

    class ScoreboardViewHolder(val binding: RowScoreboardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(result: ExamWithQuestionsAndResult) {
            binding.model = result
        }
    }

    var click: ((ExamWithQuestionsAndResult) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreboardViewHolder =
        ScoreboardViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_scoreboard_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ScoreboardViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.bind(currentItem)

        holder.binding.apply {
            root.setOnClickListener {
                click?.invoke(currentItem)
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<ExamWithQuestionsAndResult>() {
            override fun areItemsTheSame(
                oldItem: ExamWithQuestionsAndResult,
                newItem: ExamWithQuestionsAndResult
            ): Boolean =
                oldItem.exam.examId == newItem.exam.examId

            override fun areContentsTheSame(
                oldItem: ExamWithQuestionsAndResult,
                newItem: ExamWithQuestionsAndResult
            ): Boolean =
                oldItem == newItem
        }
    }
}