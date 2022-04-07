package com.ahmetbozkan.ehliyetcepte.ui.examlist

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.data.model.exam.Exam
import com.ahmetbozkan.ehliyetcepte.data.model.exam.ExamCategories
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentExamListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExamListFragment : BaseFragment<FragmentExamListBinding, ExamListViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_exam_list

    override val viewModel: ExamListViewModel by viewModels()

    private val args: ExamListFragmentArgs by navArgs()

    @Inject
    lateinit var examListAdapter: ExamListAdapter

    private lateinit var selectedCategory: ExamCategories

    override fun initialize(savedInstanceState: Bundle?) {

        getArgs()

        initRecyclerView()

        observeLiveData()

    }

    private fun getArgs() {
        selectedCategory = args.category
    }

    private fun initRecyclerView() {
        binding.rcvExams.apply {
            setHasFixedSize(true)
            adapter = examListAdapter
        }
    }

    private fun observeLiveData() {
        viewModel.getExams(selectedCategory).observe(viewLifecycleOwner, ::observeExams)
    }

    private fun observeExams(exams: List<Exam>?) {
        exams?.let {
            examListAdapter.submitList(exams)
        }
    }

}