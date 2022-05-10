package com.ahmetbozkan.ehliyetcepte.ui.common.questionnavigator

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
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

class QuestionNavigatorAdapter @Inject constructor(
    private val type: NavigatorTypes
) :
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

            root.backgroundTintList = when(type) {
                NavigatorTypes.SOLVE_EXAM -> {
                    manageSolveExamNavigatorBackground(root, currentItem)
                }
                NavigatorTypes.DISPLAY_RESULT -> {
                    manageDisplayResultNavigatorBackground(root, currentItem)
                }
            }

            root.setOnClickListener {
                click?.invoke(position)
            }
        }
    }

    private fun manageSolveExamNavigatorBackground(rootView: View, question: Question): ColorStateList? {
        return if(question.selectedOption != Options.NONE) {
            ContextCompat.getColorStateList(rootView.context, R.color.orange_warning)
        }
        else {
            ContextCompat.getColorStateList(rootView.context, android.R.color.transparent)
        }
    }

    private fun manageDisplayResultNavigatorBackground(rootView: View, question: Question): ColorStateList? {
        return when (question.selectedOption) {
            Options.NONE -> {
                ContextCompat.getColorStateList(rootView.context, android.R.color.transparent)
            }
            question.correctOption -> {
                ContextCompat.getColorStateList(rootView.context, R.color.teal_200)
            }
            else -> {
                ContextCompat.getColorStateList(rootView.context, R.color.red_error)
            }
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<Question>() {
            override fun areItemsTheSame(
                oldItem: Question,
                newItem: Question
            ): Boolean = oldItem.selectedOption == newItem.selectedOption

            override fun areContentsTheSame(
                oldItem: Question,
                newItem: Question
            ): Boolean = oldItem.selectedOption == newItem.selectedOption

        }
    }
}

enum class NavigatorTypes {
    SOLVE_EXAM,
    DISPLAY_RESULT
}