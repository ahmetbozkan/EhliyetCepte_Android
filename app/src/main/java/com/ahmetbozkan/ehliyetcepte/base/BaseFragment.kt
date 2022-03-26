package com.ahmetbozkan.ehliyetcepte.base

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.DialogFragmentNavigator
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.findNavController

abstract class BaseFragment<DB : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    private var _binding: DB? = null
    protected val binding: DB get() = _binding!!

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract val viewModel: VM

    abstract fun initialize(savedInstanceState: Bundle?)

    private val navOptions = NavOptions.Builder().setLaunchSingleTop(true).build()

    protected lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize(savedInstanceState)

        initNavigation()
    }

    private fun initNavigation() {
        navController = findNavController()
    }

    protected fun launchActivity(activity: FragmentActivity, finish: Boolean) {
        startActivity(Intent(requireContext(), activity::class.java))

        if (finish)
            requireActivity().finish()
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

    protected fun navigateWithId(destination: Int, bundle: Bundle? = null) {
        if (navController.currentDestination?.id != destination) {
            popBackStack()
            navController.navigate(destination, bundle, navOptions)
        }
    }

    protected fun popBackStack() {
        navController.popBackStack()
    }

    protected fun navigateUp() {
        navController.navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}