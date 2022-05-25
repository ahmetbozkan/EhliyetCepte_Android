package com.ahmetbozkan.ehliyetcepte.ui.countdown

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentVehicleGaugesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleGaugesFragment : BaseFragment<FragmentVehicleGaugesBinding, VehicleGaugesViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_vehicle_gauges

    override val viewModel: VehicleGaugesViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {

    }
}