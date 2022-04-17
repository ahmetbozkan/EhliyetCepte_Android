package com.ahmetbozkan.ehliyetcepte.ui.result

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentResultBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment: BaseFragment<FragmentResultBinding, ResultViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_result

    override val viewModel: ResultViewModel by viewModels()

    private val args: ResultFragmentArgs by navArgs()

    override fun initialize(savedInstanceState: Bundle?) {

        getArgs()

    }

    private fun getArgs() {
        val result = args.result

        viewModel.calculateResult(result)
    }
}