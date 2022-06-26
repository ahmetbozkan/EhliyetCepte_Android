package com.ahmetbozkan.ehliyetcepte.ui.licenceinfo

import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentDrivingLicenceClassesBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DrivingLicenceClassesFragment @Inject constructor() :
    BaseFragment<FragmentDrivingLicenceClassesBinding, DrivingLicenceInfoViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_driving_licence_classes

    override val viewModel: DrivingLicenceInfoViewModel by viewModels()

    override fun initialize(savedInstanceState: Bundle?) {
        //nothing
    }
}