package com.ahmetbozkan.ehliyetcepte.ui.cityplates

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.CityPlate
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentCityPlatesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CityPlatesFragment : BaseFragment<FragmentCityPlatesBinding, CityPlatesViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_city_plates

    override val viewModel: CityPlatesViewModel by viewModels()

    @Inject
    lateinit var plateAdapter: CityPlatesAdapter

    override fun initialize(savedInstanceState: Bundle?) {
        subscribeToViewModel()

        setCityPlatesRcv()
    }

    private fun subscribeToViewModel() {
        viewModel.cityPlate.observe(viewLifecycleOwner, ::observeCityPlates)
    }

    private fun observeCityPlates(list: List<CityPlate>) {
        plateAdapter.submitList(list)
    }

    private fun setCityPlatesRcv() = with(binding.rcvCityPlates) {
        adapter = plateAdapter
        hasFixedSize()
    }
}