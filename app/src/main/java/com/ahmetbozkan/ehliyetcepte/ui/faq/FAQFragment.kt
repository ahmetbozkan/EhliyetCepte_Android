package com.ahmetbozkan.ehliyetcepte.ui.faq

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.FAQ
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentFaqBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FAQFragment : BaseFragment<FragmentFaqBinding, FAQViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_faq

    override val viewModel: FAQViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {

        subscribeToViewModel()

    }

    private fun subscribeToViewModel() {
        viewModel.faqs.observe(viewLifecycleOwner, ::observeFAQs)
    }

    private fun observeFAQs(list: List<FAQ>) {
        requireContext().showToast(list.size.toString())
    }
}