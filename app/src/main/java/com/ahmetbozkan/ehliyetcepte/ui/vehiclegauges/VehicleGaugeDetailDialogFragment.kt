package com.ahmetbozkan.ehliyetcepte.ui.vehiclegauges

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.databinding.DialogFragmentVehicleGaugeDetailBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.loadUrl
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleGaugeDetailDialogFragment : BottomSheetDialogFragment() {

    private var _binding: DialogFragmentVehicleGaugeDetailBinding? = null
    private val binding: DialogFragmentVehicleGaugeDetailBinding get() = _binding!!

    private val args: VehicleGaugeDetailDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogFragmentVehicleGaugeDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vehicleGauge = args.vehicleGauge

        with(binding) {
            tvDescription.text = vehicleGauge.description
            imgVehicleGauge.loadUrl(vehicleGauge.imageUrl)
        }
    }

}