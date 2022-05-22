package com.ahmetbozkan.ehliyetcepte.ui.solve.wrongquestions

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Answer
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

    override fun initialize(savedInstanceState: Bundle?) {

        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.currentQuestion.observe(viewLifecycleOwner, ::observeCurrentQuestion)
    }

    private fun observeCurrentQuestion(currentQuestion: WrongQuestion) {
        val questions = viewModel.questions
        val options = currentQuestion.answers

        setFields(currentQuestion, questions, options)
    }

    private fun setFields(
        question: WrongQuestion,
        questions: List<WrongQuestion>,
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

}