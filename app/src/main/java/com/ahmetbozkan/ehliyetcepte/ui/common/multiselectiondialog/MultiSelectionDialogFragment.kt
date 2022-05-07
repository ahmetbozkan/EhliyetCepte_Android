package com.ahmetbozkan.ehliyetcepte.ui.common.multiselectiondialog

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseDialogFragment
import com.ahmetbozkan.ehliyetcepte.databinding.DialogFragmentMultiSelectionBinding
import com.ahmetbozkan.ehliyetcepte.ui.common.multiselectiondialog.MultiSelectionDialogModel.Companion.SINGLE_BUTTON_DIALOG_BUTTON_ACTION_KEY
import com.ahmetbozkan.ehliyetcepte.ui.common.multiselectiondialog.MultiSelectionDialogModel.Companion.SINGLE_BUTTON_DIALOG_RETURN_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MultiSelectionDialogFragment :
    BaseDialogFragment<DialogFragmentMultiSelectionBinding, MultiSelectionDialogViewModel>() {

    override val viewModel: MultiSelectionDialogViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.dialog_fragment_multi_selection

    private val args: MultiSelectionDialogFragmentArgs by navArgs()

    override fun initialize(savedInstanceState: Bundle?) {

        getArgs()

        manageClick()

    }

    private fun getArgs() {
        val dialogModel = args.model

        binding.model = dialogModel
    }

    private fun manageClick() {
        binding.apply {
            btnLeftButton.setOnClickListener {
                setFragmentResultAndDismiss(MultiSelectionType.SELECTION_LEFT)
            }

            btnRightButton.setOnClickListener {
                setFragmentResultAndDismiss(MultiSelectionType.SELECTION_RIGHT)
            }
        }
    }

    private fun setFragmentResultAndDismiss(type: MultiSelectionType) {
        navigateUp()

        setFragmentResult(
            SINGLE_BUTTON_DIALOG_RETURN_KEY,
            bundleOf(
                SINGLE_BUTTON_DIALOG_BUTTON_ACTION_KEY to type
            )
        )
    }


}