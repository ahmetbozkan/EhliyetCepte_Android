package com.ahmetbozkan.ehliyetcepte.ui.solve.wrongquestions

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentSolveWrongQuestionsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SolveWrongQuestionsFragment :
    BaseFragment<FragmentSolveWrongQuestionsBinding, SolveWrongQuestionsViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_solve_wrong_questions

    override val viewModel: SolveWrongQuestionsViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {
        // todo: "Not yet implemented"
    }
}