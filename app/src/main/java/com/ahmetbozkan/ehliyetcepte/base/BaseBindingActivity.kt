package com.ahmetbozkan.ehliyetcepte.base

import android.content.Intent
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel

abstract class BaseBindingActivity<DB : ViewDataBinding, VM : ViewModel> : AppCompatActivity() {

    protected lateinit var binding: DB

    protected abstract val viewModel: VM

    @LayoutRes
    abstract fun getLayoutId(): Int

    abstract fun initialize(savedInstanceState: Bundle?)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        binding.lifecycleOwner = this

        initialize(savedInstanceState)
    }

    protected fun launchActivity(activity: FragmentActivity, finish: Boolean = true) {
        startActivity(Intent(this, activity::class.java))

        if (finish)
            finish()
    }


}