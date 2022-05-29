package com.ahmetbozkan.ehliyetcepte.ui.vehiclegauges

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.VehicleGauge
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentVehicleGaugesBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class VehicleGaugesFragment : BaseFragment<FragmentVehicleGaugesBinding, VehicleGaugesViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_vehicle_gauges

    override val viewModel: VehicleGaugesViewModel by viewModels()

    @Inject
    lateinit var vehicleGaugesAdapter: VehicleGaugesAdapter

    override fun initialize(savedInstanceState: Bundle?) {

        subscribeToViewModel()

        initRecyclerView()

    }

    private fun subscribeToViewModel() {
        viewModel.vehicleGauges.observe(viewLifecycleOwner, ::observeVehicleGauges)
    }

    private fun observeVehicleGauges(vehicleGauges: List<VehicleGauge>) {
        requireContext().showToast(vehicleGauges.size.toString())

        vehicleGaugesAdapter.submitList(vehicleGauges)
    }

    private fun initRecyclerView() {
        binding.rcvVehicleGauges.apply {
            setHasFixedSize(true)
            adapter = vehicleGaugesAdapter
        }

        vehicleGaugesAdapter.click = object : (VehicleGauge) -> Unit {
            override fun invoke(entity: VehicleGauge) {
                val action = VehicleGaugesFragmentDirections
                    .actionVehicleGaugesFragmentToVehicleGaugeDetailDialogFragment(entity)

                navigate(action)
            }

        }
    }


}