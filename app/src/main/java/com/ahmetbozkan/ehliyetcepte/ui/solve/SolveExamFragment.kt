package com.ahmetbozkan.ehliyetcepte.ui.solve

import android.os.Bundle
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Answer
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentSolveExamBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.invisible
import com.ahmetbozkan.ehliyetcepte.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveExamFragment : BaseFragment<FragmentSolveExamBinding, SolveExamViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_solve_exam

    override val viewModel: SolveExamViewModel by viewModels()

    private val args: SolveExamFragmentArgs by navArgs()

    override fun initialize(savedInstanceState: Bundle?) {
        setExam()

        manageClick()

        observeLiveData()
    }

    private fun setExam() {
        val exam = args.exam

        viewModel.getExamWithQuestions(exam.examId)
    }

    private fun observeLiveData() {
        viewModel.currentQuestion.observe(viewLifecycleOwner, ::observeCurrentQuestion)
    }

    private fun observeCurrentQuestion(question: Question) {
        val exam = viewModel.examWithQuestions.exam
        val options = question.answers

        setFields(exam, question, options)
    }

    private fun setFields(exam: Exam, question: Question, options: List<Answer>) {
        binding.apply {
            tvQuestion.text = question.question
            tvExamName.text = exam.name

            rbuttonOption1.text =
                getString(R.string.question_option_format, options[0].option, options[0].optionFull)
            rbuttonOption2.text =
                getString(R.string.question_option_format, options[1].option, options[1].optionFull)
            rbuttonOption3.text =
                getString(R.string.question_option_format, options[2].option, options[2].optionFull)
            rbuttonOption4.text =
                getString(R.string.question_option_format, options[3].option, options[3].optionFull)

            val currentSelectedOption = viewModel.selectedOptions[question.questionId]

            if (currentSelectedOption != null) {
                rgroupOptions.findViewWithTag<AppCompatRadioButton>(
                    currentSelectedOption.name
                ).isChecked = true
            } else
                rgroupOptions.clearCheck()

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

    private fun manageClick() {
        binding.apply {
            btnPreviousQuestion.setOnClickListener {
                viewModel.onPreviousQuestionClicked()
            }

            btnNextQuestion.setOnClickListener {
                viewModel.onNextQuestionClicked()
            }

            rbuttonOption1.setOnClickListener {

            }

            rbuttonOption2.setOnClickListener {

            }

            rbuttonOption3.setOnClickListener {

            }

            rbuttonOption4.setOnClickListener {

            }
        }
    }

}