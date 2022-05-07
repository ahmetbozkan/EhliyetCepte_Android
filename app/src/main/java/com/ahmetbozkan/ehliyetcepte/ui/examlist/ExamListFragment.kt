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

        viewModel.getExams(selectedCategory)
    }

    private fun initRecyclerView() {
        binding.rcvExams.apply {
            setHasFixedSize(true)
            adapter = examListAdapter
        }

        examListAdapter.click = object : (Exam) -> Unit {
            override fun invoke(exam: Exam) {
                /*
                if (exam.solved) {
                    Toast.makeText(requireContext(), "Bu sınav çözüldü", Toast.LENGTH_SHORT).show()
                    return
                }
                */

                val action = ExamListFragmentDirections
                    .actionExamListFragmentToSolveExamFragment(exam)
                navigate(action)
            }
        }
    }

    private fun observeLiveData() {
        viewModel.exams.observe(viewLifecycleOwner, ::observeExams)
    }

    private fun observeExams(exams: List<Exam>?) {
        exams?.let {
            examListAdapter.submitList(exams)
        }
    }

}