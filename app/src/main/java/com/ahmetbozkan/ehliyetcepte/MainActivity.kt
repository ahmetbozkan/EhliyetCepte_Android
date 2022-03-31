package com.ahmetbozkan.ehliyetcepte

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.ahmetbozkan.ehliyetcepte.base.BaseBindingActivity
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamWithQuestionsAndAnswers
import com.ahmetbozkan.ehliyetcepte.databinding.ActivityMainBinding
import com.ahmetbozkan.ehliyetcepte.util.extension.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseBindingActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_main

    private lateinit var navController: NavController

    override fun initialize(savedInstanceState: Bundle?) {

        initNavigation()

        observeLiveData()

    }

    private fun observeLiveData() {
        viewModel.examCount.observe(this, ::observeExamCount)
        viewModel.getExams(ExamCategories.PILOT).observe(this, ::observeExams)
    }

    private fun observeExamCount(count: Int) {
        showToast(count.toString())
    }

    private fun observeExams(exams: LiveData<List<ExamWithQuestionsAndAnswers>>?) {
        exams?.let {
            showToast(it.value?.size.toString())
        }
    }

    private fun initNavigation() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.findNavController()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


}