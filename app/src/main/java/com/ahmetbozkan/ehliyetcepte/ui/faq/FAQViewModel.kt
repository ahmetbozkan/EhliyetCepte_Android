package com.ahmetbozkan.ehliyetcepte.ui.faq

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ahmetbozkan.ehliyetcepte.base.BaseViewModel
import com.ahmetbozkan.ehliyetcepte.core.Status
import com.ahmetbozkan.ehliyetcepte.data.model.usefultopics.FAQ
import com.ahmetbozkan.ehliyetcepte.domain.usecase.faq.GetFAQUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FAQViewModel @Inject constructor(
    private val getFAQUseCase: GetFAQUseCase
) : BaseViewModel() {

    private val _faqs = MutableLiveData<List<FAQ>>()
    val faqs: LiveData<List<FAQ>> get() = _faqs

    init {
        getFrequentlyAskedQuestions()
    }

    private fun getFrequentlyAskedQuestions() =
        viewModelScope.launch(Dispatchers.IO + genericExceptionHandler) {
            enableLoading()

            val result = getFAQUseCase.invoke()

            when (result.status) {
                Status.SUCCESS -> {
                    disableLoading()
                    _faqs.postValue(result.data!!)
                }
                Status.ERROR -> {
                    manageException(result.error)
                }
            }
        }

}