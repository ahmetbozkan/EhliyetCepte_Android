package com.ahmetbozkan.ehliyetcepte.ui.examlist

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.ahmetbozkan.ehliyetcepte.R
import com.ahmetbozkan.ehliyetcepte.base.BaseFragment
import com.ahmetbozkan.ehliyetcepte.databinding.FragmentExamListBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExamListFragment : BaseFragment<FragmentExamListBinding, ExamListViewModel>() {

    override fun getLayoutId(): Int = R.layout.fragment_exam_list

    override val viewModel: ExamListViewModel by viewModels()

    @Inject
    lateinit var adapter: ExamListAdapter

    override fun initialize(savedInstanceState: Bundle?) {
        // todo: Selected category will be passed here from LandingFragment,
        // todo: Using that id, Exams will be get from the db
    }
}