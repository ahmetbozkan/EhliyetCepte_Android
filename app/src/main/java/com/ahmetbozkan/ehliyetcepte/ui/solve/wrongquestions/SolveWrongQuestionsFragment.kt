package com.ahmetbozkan.ehliyetcepte.ui.solve.wrongquestions

import android.os.Bundle
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Answer
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import com.ahmetbozkan.ehliyetcepte.data.model.exam.WrongQuestion
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentSolveWrongQuestionsBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.gone
import com.ahmetbozkan.ehliyetcepte.util.extension.loadUrl
import com.ahmetbozkan.ehliyetcepte.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveWrongQuestionsFragment :
    BaseFragment<FragmentSolveWrongQuestionsBinding, SolveWrongQuestionsViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_solve_wrong_questions

    override val viewModel: SolveWrongQuestionsViewModel by viewModels()

    private lateinit var currentQuestion: WrongQuestion

    override fun initialize(savedInstanceState: Bundle?) {

        observeLiveData()

        manageClick()
    }

    private fun observeLiveData() {
        viewModel.currentQuestion.observe(viewLifecycleOwner, ::observeCurrentQuestion)
    }

    private fun observeCurrentQuestion(currentQuestion: WrongQuestion) {
        this.currentQuestion = currentQuestion
        val options = currentQuestion.answers

        setFields(currentQuestion, options)
    }

    private fun setFields(
        question: WrongQuestion,
        options: List<Answer>
    ) {
        binding.apply {
            tvQuestion.text = question.question

            if (question.imageUrl.isNotEmpty()) {
                imgQuestion.visible()
                imgQuestion.loadUrl(question.imageUrl)
            } else imgQuestion.gone()

            rbuttonOption1.text =
                getString(R.string.question_option_format, options[0].option, options[0].optionFull)
            rbuttonOption2.text =
                getString(R.string.question_option_format, options[1].option, options[1].optionFull)
            rbuttonOption3.text =
                getString(R.string.question_option_format, options[2].option, options[2].optionFull)
            rbuttonOption4.text =
                getString(R.string.question_option_format, options[3].option, options[3].optionFull)
        }
    }

    private fun onOptionSelected(option: Options) {
        binding.apply {
            btnNextQuestion.visible()
            manageSelectedOption(currentQuestion, option)
            setOptionsClickable(false)
        }
    }

    private fun setOptionsClickable(clickable: Boolean) = with(binding) {
        rbuttonOption1.isEnabled = clickable
        rbuttonOption2.isEnabled = clickable
        rbuttonOption3.isEnabled = clickable
        rbuttonOption4.isEnabled = clickable
    }

    private fun manageSelectedOption(currentQuestion: WrongQuestion, selectedOption: Options) {
        resetOptionBackgrounds()

        if (selectedOption == currentQuestion.correctOption) {
            binding.rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                currentQuestion.correctOption.name
            ).background = ContextCompat.getDrawable(requireContext(), R.color.teal_200)
        } else {
            binding.rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                currentQuestion.correctOption.name
            ).background = ContextCompat.getDrawable(requireContext(), R.color.teal_200)

            binding.rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                selectedOption.name
            ).background = ContextCompat.getDrawable(requireContext(), R.color.red_error)
        }
    }

    private fun resetOptionBackgrounds() = with(binding) {
        rbuttonOption1.background = null
        rbuttonOption2.background = null
        rbuttonOption3.background = null
        rbuttonOption4.background = null
    }

    private fun manageClick() = with(binding) {
        rgroupOptions.setOnCheckedChangeListener { _, id ->
            when (id) {
                R.id.rbutton_option1 -> onOptionSelected(Options.A)
                R.id.rbutton_option2 -> onOptionSelected(Options.B)
                R.id.rbutton_option3 -> onOptionSelected(Options.C)
                R.id.rbutton_option4 -> onOptionSelected(Options.D)
            }
        }

        btnNextQuestion.setOnClickListener {
            viewModel.onNextQuestionClicked()
        }
    }

}