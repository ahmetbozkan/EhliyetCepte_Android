package com.ahmetbozkan.ehliyetcepte.ui.result

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.result.Result
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultFragment : BaseFragment<FragmentResultBinding, ResultViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_result

    override val viewModel: ResultViewModel by viewModels()

    private val args: ResultFragmentArgs by navArgs()

    @Inject
    lateinit var resultAdapter: ResultAdapter

    override fun initialize(savedInstanceState: Bundle?) {

        getArgs()

        initRecyclerView()

        observeLiveData()

    }

    private fun getArgs() {
        val result = args.result

        onExamFinished(result)
    }

    private fun onExamFinished(result: SolvedExamEntity) {
        viewModel.onExamFinished(result)

        resultAdapter.submitList(result.examWithQuestions.questions)
    }

    private fun observeLiveData() {
        viewModel.calculatedResult.observe(viewLifecycleOwner, ::observeCalculatedResult)
    }

    private fun observeCalculatedResult(result: Result) {
        binding.result = result
    }

    private fun initRecyclerView() {
        binding.rcvResult.apply {
            setHasFixedSize(true)
            adapter = resultAdapter
        }
    }
}