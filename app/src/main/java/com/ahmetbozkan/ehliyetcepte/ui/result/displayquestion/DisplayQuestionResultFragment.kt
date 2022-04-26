package com.ahmetbozkan.ehliyetcepte.ui.result.displayquestion

import android.os.Bundle
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentDisplayQuestionResultBinding
import com.ahmetbozkan.ehliyetcepte.ui.result.ResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayQuestionResultFragment :
    BaseFragment<FragmentDisplayQuestionResultBinding, ResultViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_display_question_result

    override val viewModel: ResultViewModel by viewModels()

    private val args: DisplayQuestionResultFragmentArgs by navArgs()

    override fun initialize(savedInstanceState: Bundle?) {

        getArgs()

    }

    private fun getArgs() {
        val question = args.question
        val examName = args.examName

        setFields(question, examName)
    }

    private fun setFields(question: Question, examName: String) {
        binding.apply {
            tvExamName.text = examName
            tvQuestion.text = question.question

            val options = question.answers

            rbuttonOption1.text =
                getString(R.string.question_option_format, options[0].option, options[0].optionFull)
            rbuttonOption2.text =
                getString(R.string.question_option_format, options[1].option, options[1].optionFull)
            rbuttonOption3.text =
                getString(R.string.question_option_format, options[2].option, options[2].optionFull)
            rbuttonOption4.text =
                getString(R.string.question_option_format, options[3].option, options[3].optionFull)

            if (question.selectedOption == Options.NONE) {
                rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                    question.correctOption
                ).isChecked = true
            }
        }
    }
}