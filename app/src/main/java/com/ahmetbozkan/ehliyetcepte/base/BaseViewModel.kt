package com.ahmetbozkan.ehliyetcepte.base

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel : ViewModel() {

    val genericExceptionHandler = CoroutineExceptionHandler { _, t ->
        Log.e("COROUTINE ERROR", "Error: ${t.message}")
    }

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _error = MutableLiveData<Exception?>()
    val error: LiveData<Exception?> get() = _error

    protected fun enableLoading() {
        _isLoading.postValue(true)
    }

    protected fun disableLoading() {
        _isLoading.postValue(false)
    }

    protected fun manageException(error: Exception?) {
        disableLoading()
        _error.postValue(error)
    }

}