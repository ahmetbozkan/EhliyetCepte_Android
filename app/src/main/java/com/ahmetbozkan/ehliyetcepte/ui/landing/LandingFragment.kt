package com.ahmetbozkan.ehliyetcepte.ui.landing

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentLandingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingFragment : BaseFragment<FragmentLandingBinding, LandingViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_landing

    override val viewModel: LandingViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {

        manageClick()

    }

    private fun manageClick() {
        binding.apply {
            btnOpenPilotExams.setOnClickListener {
                val action = LandingFragmentDirections
                    .actionLandingFragmentToExamListFragment(ExamCategories.PILOT)

                navigate(action)
            }

            btnScoreboard.setOnClickListener {
                val action = LandingFragmentDirections.actionLandingFragmentToScoreboardFragment()

                navigate(action)
            }
        }
    }

}