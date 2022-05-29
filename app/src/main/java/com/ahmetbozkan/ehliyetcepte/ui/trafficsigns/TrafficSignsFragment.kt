package com.ahmetbozkan.ehliyetcepte.ui.trafficsigns

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.TrafficSign
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentTrafficSignsBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TrafficSignsFragment : BaseFragment<FragmentTrafficSignsBinding, TrafficSignsViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_traffic_signs

    override val viewModel: TrafficSignsViewModel by viewModels()

    @Inject
    lateinit var trafficSignsAdapter: TrafficSignsAdapter

    override fun initialize(savedInstanceState: Bundle?) {

        subscribeToViewModel()

        initRecyclerView()
    }

    private fun subscribeToViewModel() {
        viewModel.trafficSigns.observe(viewLifecycleOwner, ::observeTrafficSigns)
    }

    private fun observeTrafficSigns(list: List<TrafficSign>) {
        trafficSignsAdapter.submitList(list)
    }

    private fun initRecyclerView() {
        binding.rcvTrafficSigns.apply {
            setHasFixedSize(true)
            adapter = trafficSignsAdapter
        }

        trafficSignsAdapter.click = object : (TrafficSign) -> Unit {
            override fun invoke(entity: TrafficSign) {
                val action = TrafficSignsFragmentDirections
                    .actionTrafficSignsFragmentToTrafficSignDetailDialogFragment(entity)
                navigate(action)
            }

        }
    }
}