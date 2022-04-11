package com.ahmetbozkan.ehliyetcepte.base

import com.ahmetbozkan.ehliyetcepte.core.Resource

abstract class BaseDataSource {

    protected suspend fun <T> handleOperation(call: suspend () -> T): Resource<T> {
        return try {
            val response = call()
            Resource.success(response)
        } catch (exception: Exception) {
            Resource.error(error = exception)
        }
    }

}