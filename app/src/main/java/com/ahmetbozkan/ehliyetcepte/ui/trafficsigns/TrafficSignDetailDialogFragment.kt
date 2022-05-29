package com.ahmetbozkan.ehliyetcepte.ui.trafficsigns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.databinding.DialogFragmentTrafficSignDetailBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.loadUrl
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrafficSignDetailDialogFragment : BottomSheetDialogFragment() {

    private var _binding: DialogFragmentTrafficSignDetailBinding? = null
    private val binding: DialogFragmentTrafficSignDetailBinding get() = _binding!!

    private val args: TrafficSignDetailDialogFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DialogFragmentTrafficSignDetailBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vehicleGauge = args.trafficSign

        with(binding) {
            tvDescription.text = vehicleGauge.description
            imgVehicleGauge.loadUrl(vehicleGauge.imageUrl)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}