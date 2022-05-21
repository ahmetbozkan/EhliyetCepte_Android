package com.ahmetbozkan.ehliyetcepte.ui.scoreboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestions
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentScoreboardBinding
import com.ahmetbozkan.ehliyetcepte.ui.common.examcategory.ExamCategory
import com.ahmetbozkan.ehliyetcepte.ui.common.examcategory.ExamCategoryAdapter
import com.ahmetbozkan.ehliyetcepte.util.Event
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScoreboardFragment : BaseFragment<FragmentScoreboardBinding, ScoreboardViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_scoreboard

    override val viewModel: ScoreboardViewModel by viewModels()

    @Inject
    lateinit var scoreboardAdapter: ScoreboardAdapter

    @Inject
    lateinit var examCategoriesAdapter: ExamCategoryAdapter

    override fun initialize(savedInstanceState: Bundle?) {

        observeLiveData()

        setScoreboardRecyclerView()

        setExamCategoryRecyclerView()

    }

    private fun observeLiveData() {
        viewModel.results.observe(viewLifecycleOwner, ::observeResults)
        viewModel.examWithQuestions.observe(viewLifecycleOwner, ::observeExamWithQuestions)
    }

    private fun observeResults(list: List<ExamWithQuestionsAndResult>) {
        scoreboardAdapter.submitList(list)
    }

    private fun observeExamWithQuestions(result: Event<ExamWithQuestions>) {
        result.getContentIfNotHandled()?.let {
            val action = ScoreboardFragmentDirections
                .actionScoreboardFragmentToDisplayQuestionResultFragment(
                    0,
                    result.peekContent()
                )

            navigate(action)
        }
    }

    private fun setExamCategoryRecyclerView() {
        binding.rcvCategoriesFilter.apply {
            setHasFixedSize(true)
            adapter = examCategoriesAdapter
        }

        examCategoriesAdapter.click = object : (ExamCategory) -> Unit {
            override fun invoke(category: ExamCategory) {
                viewModel.onCategorySelected(category.category)

                examCategoriesAdapter.onCategorySelected(category)
            }
        }

        setCategories()
    }

    private fun setCategories() {
        val categories = ExamCategories.values().map { category ->
            ExamCategory(category.value, category, false)
        }.apply {
            find { it.id == ExamCategories.ALL.value }?.isSelected = true
        }

        examCategoriesAdapter.submitList(categories)
    }

    private fun setScoreboardRecyclerView() {
        binding.rcvScoreboard.apply {
            hasFixedSize()
            adapter = scoreboardAdapter
        }

        scoreboardAdapter.click = object : (ExamWithQuestionsAndResult) -> Unit {
            override fun invoke(entity: ExamWithQuestionsAndResult) {
                viewModel.onScoreClicked(entity.exam.examId)
            }

        }
    }
}