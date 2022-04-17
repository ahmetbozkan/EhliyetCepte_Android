package com.ahmetbozkan.ehliyetcepte.base

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController

abstract class BaseDialogFragment<DB : ViewDataBinding, VM : BaseViewModel> : DialogFragment() {

    private var _binding: DB? = null
    protected val binding: DB get() = _binding!!

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val viewModel: VM

    abstract fun initialize(savedInstanceState: Bundle?)

    protected lateinit var navController: NavController
    private val navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)

        dialog.apply {
            setCancelable(false)
            setCanceledOnTouchOutside(false)
        }

        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, android.R.style.Theme_Material_Dialog_NoActionBar_MinWidth)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(
            inflater,
            getLayoutId(),
            container,
            false
        )

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initNavigation()

        initDataBinding()

        initialize(savedInstanceState)
    }

    private fun initNavigation() {
        navController = findNavController()
    }

    private fun initDataBinding() {
        binding.lifecycleOwner = this
    }

    protected fun launchActivity(activity: FragmentActivity, finish: Boolean = true) {
        startActivity(Intent(requireContext(), activity::class.java))

        if (finish)
            requireActivity().finish()
    }

    protected fun navigateWithId(destination: Int, bundle: Bundle? = null) {
        if (navController.currentDestination?.id != destination) {
            popBackStack()
            navController.navigate(destination, bundle, navOptions)
        }
    }

    // ensure the current destination is the parent destination before navigation
    // otherwise it will crash when executing navigate() multiple times at once
    protected fun navigate(directions: NavDirections) {
        val currentDestination =
            (navController.currentDestination as? FragmentNavigator.Destination)?.className
                ?: (navController.currentDestination as? DialogFragmentNavigator.Destination)?.className

        if (currentDestination == this.javaClass.name)
            navController.navigate(directions)
    }

    protected fun popBackStack() {
        navController.popBackStack()
    }

    protected fun navigateUp() {
        navController.navigateUp()
    }

    protected fun navigateBack() {
        navController.navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}