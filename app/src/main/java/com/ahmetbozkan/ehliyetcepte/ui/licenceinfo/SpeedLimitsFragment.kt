package com.ahmetbozkan.ehliyetcepte.ui.licenceinfo

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentSpeedLimitsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SpeedLimitsFragment @Inject constructor() :
    BaseFragment<FragmentSpeedLimitsBinding, DrivingLicenceInfoViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_speed_limits

    override val viewModel: DrivingLicenceInfoViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {
        //nothing
    }
}