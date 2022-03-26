package com.ahmetbozkan.ehliyetcepte.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler

abstract class BaseViewModel : ViewModel() {

    val genericExceptionHandler = CoroutineExceptionHandler { _, t ->
        Log.e("COROUTINE ERROR", "Error: ${t.message}")
    }

}