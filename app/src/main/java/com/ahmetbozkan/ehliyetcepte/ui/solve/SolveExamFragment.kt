package com.ahmetbozkan.ehliyetcepte.ui.solve

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentSolveExamBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveExamFragment : BaseFragment<FragmentSolveExamBinding, SolveExamViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_solve_exam

    override val viewModel: SolveExamViewModel by viewModels()

    private val args: SolveExamFragmentArgs by navArgs()

    private lateinit var questions: List<Question>
    private lateinit var currentQuestion: Question

    override fun initialize(savedInstanceState: Bundle?) {
        setExam()

        observeLiveData()
    }

    private fun setExam() {
        val exam = args.exam

        viewModel.getExamWithQuestions(exam.examId)
    }

    private fun observeLiveData() {
        viewModel.exam.observe(viewLifecycleOwner, ::observeExamWithQuestions)
    }

    private fun observeExamWithQuestions(exam: ExamWithQuestions) {
        questions = exam.questions
        currentQuestion = questions[0]

        binding.question = currentQuestion
    }

}