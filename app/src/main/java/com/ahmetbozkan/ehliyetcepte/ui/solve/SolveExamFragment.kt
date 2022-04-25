package com.ahmetbozkan.ehliyetcepte.ui.solve

import android.os.Bundle
import android.os.SystemClock
import android.widget.Chronometer
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Answer
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Options
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Question
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentSolveExamBinding
import com.ahmetbozkan.ehliyetcepte.ui.common.MultiSelectionDialogModel
import com.ahmetbozkan.ehliyetcepte.ui.common.MultiSelectionType
import com.ahmetbozkan.ehliyetcepte.ui.result.SolvedExamEntity
import com.ahmetbozkan.ehliyetcepte.util.extension.invisible
import com.ahmetbozkan.ehliyetcepte.util.extension.orZero
import com.ahmetbozkan.ehliyetcepte.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveExamFragment : BaseFragment<FragmentSolveExamBinding, SolveExamViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_solve_exam

    override val viewModel: SolveExamViewModel by viewModels()

    private val args: SolveExamFragmentArgs by navArgs()

    private lateinit var chronometer: Chronometer
    private var pauseOffset: Long = 0
    private var running = false

    override fun initialize(savedInstanceState: Bundle?) {

        init()

        setExam()

        manageClick()

        observeLiveData()
    }

    private fun init() {
        chronometer = binding.chronometer

        startTimer()
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
                manageOptionSelection(Options.A)
            }

            rbuttonOption2.setOnClickListener {
                manageOptionSelection(Options.B)
            }

            rbuttonOption3.setOnClickListener {
                manageOptionSelection(Options.C)
            }

            rbuttonOption4.setOnClickListener {
                manageOptionSelection(Options.D)
            }

            btnEndExam.setOnClickListener {
                onEndExamClicked()
            }
        }
    }

    private fun manageOptionSelection(selectedOption: Options) {
        val currentQuestionId = viewModel.currentQuestion.value?.questionId.orZero()
        val currentSelectedOption = viewModel.selectedOptions[currentQuestionId]

        if (currentSelectedOption != null && currentSelectedOption == selectedOption) {
            viewModel.onOptionSelected(Options.NONE, isSelectedOptionSame = true)
            binding.rgroupOptions.clearCheck()
        } else
            viewModel.onOptionSelected(selectedOption, isSelectedOptionSame = false)
    }

    private fun onEndExamClicked() {
        val action = SolveExamFragmentDirections.actionGlobalMultiSelectionDialogFragment(
            MultiSelectionDialogModel(
                title = "Sınavı bitirmek istediğinizden emin misiniz?",
                description = "Daha sonra sınava geri dönemeyeceksiniz!",
                rightButtonText = "BİTİR",
                rightButtonBgColor = R.color.teal_700,
                rightButtonTextColor = R.color.white,
                rightButtonStrokeColor = R.color.black,
                leftButtonText = "İPTAL",
                leftButtonTextColor = R.color.white,
                leftButtonBgColor = R.color.teal_200,
                leftButtonStrokeColor = R.color.black,
                iconRes = R.drawable.ic_info,
                iconTint = R.color.orange_warning
            )
        )

        setDialogResult()

        pauseTimer()
        navigate(action)
    }

    private fun setDialogResult() {
        setFragmentResultListener(MultiSelectionDialogModel.SINGLE_BUTTON_DIALOG_RETURN_KEY) { _, bundle ->
            val selection = bundle.getSerializable(
                MultiSelectionDialogModel.SINGLE_BUTTON_DIALOG_BUTTON_ACTION_KEY
            ) as MultiSelectionType

            if (selection == MultiSelectionType.SELECTION_RIGHT) {
                navigateToResultFragment()
            }

            startTimer()
        }
    }

    private fun navigateToResultFragment() {
        setExamDuration()

        val action = SolveExamFragmentDirections.actionSolveExamFragmentToResultFragment(
            SolvedExamEntity(
                examId = viewModel.examWithQuestions.exam.examId,
                answers = viewModel.selectedOptions,
                examWithQuestions = viewModel.examWithQuestions
            )
        )

        navigate(action)
    }

    private fun setExamDuration() {
        val duration = SystemClock.elapsedRealtime() - binding.chronometer.base
        viewModel.examWithQuestions.exam.duration = duration
    }

    private fun startTimer() {
        if (running)
            return

        binding.chronometer.apply {
            base = SystemClock.elapsedRealtime() - pauseOffset
            start()
            running = true
        }
    }

    private fun pauseTimer() {
        if (!running)
            return

        binding.chronometer.apply {
            chronometer.stop()
            pauseOffset = SystemClock.elapsedRealtime() - this.base
            running = false
        }
    }

}