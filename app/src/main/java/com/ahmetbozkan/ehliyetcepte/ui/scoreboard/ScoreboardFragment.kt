package com.ahmetbozkan.ehliyetcepte.ui.scoreboard

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.result.ExamWithQuestionsAndResult
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentScoreboardBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScoreboardFragment : BaseFragment<FragmentScoreboardBinding, ScoreboardViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_scoreboard

    override val viewModel: ScoreboardViewModel by viewModels()

    @Inject
    lateinit var scoreboardAdapter: ScoreboardAdapter

    override fun initialize(savedInstanceState: Bundle?) {

        observeLiveData()

        setScoreboardRecyclerView()

    }

    private fun observeLiveData() {
        viewModel.results.observe(viewLifecycleOwner, ::observeResults)
    }

    private fun observeResults(list: List<ExamWithQuestionsAndResult>) {
        scoreboardAdapter.submitList(list)
    }


    private fun setScoreboardRecyclerView() {
        binding.rcvScoreboard.apply {
            hasFixedSize()
            adapter = scoreboardAdapter
        }

        scoreboardAdapter.click = object : (ExamWithQuestionsAndResult) -> Unit {
            override fun invoke(entity: ExamWithQuestionsAndResult) {
                // todo: navigate to display results page
            }

        }
    }
}