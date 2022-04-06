package com.ahmetbozkan.ehliyetcepte.ui.examlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.databinding.RowExamItemBinding
import javax.inject.Inject

class ExamListAdapter @Inject constructor() :
    ListAdapter<Exam, ExamListAdapter.ExamListViewHolder>(diffUtil) {

    class ExamListViewHolder(private val binding: RowExamItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exam: Exam) {
            binding.exam = exam
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamListViewHolder =
        ExamListViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_exam_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ExamListViewHolder, position: Int) {
        val currentItem = getItem(position)

        holder.bind(currentItem)
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Exam>() {
            override fun areItemsTheSame(oldItem: Exam, newItem: Exam): Boolean =
                oldItem.examId == newItem.examId

            override fun areContentsTheSame(oldItem: Exam, newItem: Exam): Boolean =
                oldItem == newItem
        }
    }

}