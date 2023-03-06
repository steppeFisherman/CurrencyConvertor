package com.example.currencyconvertor.domain.model

sealed class MyResult {
    data class Success(val data: DataDomain) : MyResult()
    data class Fail(val errorType: ErrorType) : MyResult()
}
