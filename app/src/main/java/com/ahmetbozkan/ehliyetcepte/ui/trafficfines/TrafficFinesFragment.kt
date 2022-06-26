package com.ahmetbozkan.ehliyetcepte.ui.trafficfines

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficFine
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentTrafficFinesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TrafficFinesFragment : BaseFragment<FragmentTrafficFinesBinding, TrafficFinesViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_traffic_fines

    override val viewModel: TrafficFinesViewModel by viewModels()

    @Inject
    lateinit var trafficFinesAdapter: TrafficFinesAdapter

    override fun initialize(savedInstanceState: Bundle?) {
        subscribeToViewModel()

        setTrafficFinesAdapter()
    }

    private fun subscribeToViewModel() {
        viewModel.trafficFines.observe(viewLifecycleOwner, ::observeTrafficFines)
    }

    private fun observeTrafficFines(list: List<TrafficFine>) {
        trafficFinesAdapter.submitList(list)
    }

    private fun setTrafficFinesAdapter() = with(binding.rcvTrafficFines) {
        hasFixedSize()
        adapter = trafficFinesAdapter
    }
}