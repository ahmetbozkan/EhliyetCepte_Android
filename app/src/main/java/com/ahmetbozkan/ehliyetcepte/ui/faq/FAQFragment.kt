package com.ahmetbozkan.ehliyetcepte.ui.faq

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.FAQ
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentFaqBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FAQFragment : BaseFragment<FragmentFaqBinding, FAQViewModel>() {
    override fun getLayoutId(): Int = R.layout.fragment_faq

    override val viewModel: FAQViewModel by viewModels()

    @Inject
    lateinit var faqAdapter: FAQAdapter

    override fun initialize(savedInstanceState: Bundle?) {

        subscribeToViewModel()

        setFAQAdapter()

    }

    private fun subscribeToViewModel() {
        viewModel.faqs.observe(viewLifecycleOwner, ::observeFAQs)
    }

    private fun observeFAQs(list: List<FAQ>) {
        faqAdapter.submitList(list)
    }

    private fun setFAQAdapter() = with(binding.rcvFaq) {
        hasFixedSize()
        adapter = faqAdapter
    }
}