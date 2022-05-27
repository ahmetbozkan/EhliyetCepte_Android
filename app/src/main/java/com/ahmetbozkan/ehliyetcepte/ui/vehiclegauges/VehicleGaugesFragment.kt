package com.ahmetbozkan.ehliyetcepte.ui.vehiclegauges

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.vehiclegauges.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentVehicleGaugesBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.orZero
import com.ahmetbozkan.ehliyetcepte.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleGaugesFragment : BaseFragment<FragmentVehicleGaugesBinding, VehicleGaugesViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_vehicle_gauges

    override val viewModel: VehicleGaugesViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {

        subscribeToViewModel()

    }

    private fun subscribeToViewModel() {
        viewModel.vehicleGauges.observe(viewLifecycleOwner, ::observeVehicleGauges)
    }

    private fun observeVehicleGauges(vehicleGauges: List<VehicleGauge>) {
        requireContext().showToast(vehicleGauges.size.toString())
    }


}