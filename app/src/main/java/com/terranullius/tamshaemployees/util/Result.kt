package com.terranullius.tamshaemployees.util

sealed class Result<T>(
    val data: T? = null,
    val error: Throwable? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Loading<T>(data: T? = null) : Result<T>(data)
    class Error<T>(val throwable: Throwable, data: T? = null) : Result<T>(data, throwable) {
        val errorMessage: String
            get() = throwable.localizedMessage ?: GENERIC_ERROR_MESSAGE

        companion object {
            const val GENERIC_ERROR_MESSAGE = "Something went wrong"
        }
    }

}