package com.example.currencyconvertor.data.repository

import com.example.currencyconvertor.domain.model.ErrorType
import com.example.currencyconvertor.domain.model.MyResult
import retrofit2.HttpException
import java.net.UnknownHostException

interface ExceptionHandle {

    fun handle(exception: Exception?): MyResult

    class Base : ExceptionHandle {
        override fun handle(exception: Exception?): MyResult = MyResult.Fail(
            when (exception) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.HTTP_EXCEPTION
                else -> ErrorType.GENERIC_ERROR
            }
        )
    }
}
