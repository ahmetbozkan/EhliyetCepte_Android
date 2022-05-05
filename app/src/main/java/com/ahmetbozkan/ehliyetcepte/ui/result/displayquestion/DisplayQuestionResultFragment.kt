package com.ahmetbozkan.ehliyetcepte.ui.result.displayquestion

import android.os.Bundle
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentDisplayQuestionResultBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.invisible
import com.ahmetbozkan.ehliyetcepte.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayQuestionResultFragment :
    BaseFragment<FragmentDisplayQuestionResultBinding, DisplayQuestionResultViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_display_question_result

    override val viewModel: DisplayQuestionResultViewModel by viewModels()

    private val args: DisplayQuestionResultFragmentArgs by navArgs()

    private lateinit var questions: List<Question>

    override fun initialize(savedInstanceState: Bundle?) {
        getArgs()

        manageClick()

        observeLiveData()
    }

    private fun getArgs() {
        viewModel.setInitialQuestion(args.questionPosition, args.examWithQuestions)
    }

    private fun manageClick() {
        binding.apply {
            btnPreviousQuestion.setOnClickListener {
                viewModel.onPreviousQuestionClicked()
            }

            btnNextQuestion.setOnClickListener {
                viewModel.onNextQuestionClicked()
            }
        }
    }

    private fun observeLiveData() {
        viewModel.currentQuestion.observe(viewLifecycleOwner, ::observeCurrentQuestion)
    }

    private fun observeCurrentQuestion(question: Question) {
        binding.apply {
            tvExamName.text = viewModel.examWithQuestions.exam.name
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

            manageSelectedOption(question)

            if (viewModel.index == 0)
                btnPreviousQuestion.invisible()
            else
                btnPreviousQuestion.visible()

            if (viewModel.index == viewModel.examWithQuestions.questions.size - 1)
                btnNextQuestion.invisible()
            else
                btnNextQuestion.visible()
        }
    }

    private fun manageSelectedOption(question: Question) {
        resetOptionBackgrounds()

        if (question.selectedOption == Options.NONE || question.selectedOption == question.correctOption) {
            binding.rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                question.correctOption.name
            ).background = ContextCompat.getDrawable(requireContext(), R.color.teal_200)
        } else {
            binding.rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                question.correctOption.name
            ).background = ContextCompat.getDrawable(requireContext(), R.color.teal_200)

            binding.rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                question.selectedOption.name
            ).background = ContextCompat.getDrawable(requireContext(), R.color.red_error)
        }
    }

    private fun resetOptionBackgrounds() {
        binding.rbuttonOption1.background = null
        binding.rbuttonOption2.background = null
        binding.rbuttonOption3.background = null
        binding.rbuttonOption4.background = null
    }
}
