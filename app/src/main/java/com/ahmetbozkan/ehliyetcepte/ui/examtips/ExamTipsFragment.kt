package com.ahmetbozkan.ehliyetcepte.ui.examtips

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.ExamTip
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentExamTipsBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.invisible
import com.ahmetbozkan.ehliyetcepte.util.extension.loadUrl
import com.ahmetbozkan.ehliyetcepte.util.extension.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExamTipsFragment : BaseFragment<FragmentExamTipsBinding, ExamTipsViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_exam_tips

    override val viewModel: ExamTipsViewModel by viewModels()

    private val args: ExamTipsFragmentArgs by navArgs()

    override fun initialize(savedInstanceState: Bundle?) {

        getArgs()

        manageClick()

        subscribeToViewModel()

    }

    private fun getArgs() {
        val tipType = args.type

        viewModel.getExamTips(tipType)
    }

    private fun subscribeToViewModel() {
        viewModel.currentTip.observe(viewLifecycleOwner, ::observeCurrentTip)
    }

    private fun observeCurrentTip(examTip: ExamTip) = with(binding) {
        tvTitle.text = examTip.title
        tvDescription.text = examTip.description
        imgTip.loadUrl(examTip.imageUrl)

        if (viewModel.index == 0) btnPreviousTip.invisible()
        else btnPreviousTip.visible()

        if (viewModel.index == viewModel.tips.size - 1) btnNextTip.invisible()
        else btnNextTip.visible()
    }

    private fun manageClick() = with(binding) {
        btnPreviousTip.setOnClickListener {
            viewModel.onPreviousTipClicked()
        }

        btnNextTip.setOnClickListener {
            viewModel.onNextTipClicked()
        }
    }
}