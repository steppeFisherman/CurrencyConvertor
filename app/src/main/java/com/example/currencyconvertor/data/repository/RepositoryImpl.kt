package com.example.currencyconvertor.data.repository

import com.example.currencyconvertor.domain.Repository
import com.example.currencyconvertor.domain.model.MyResult
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val cloudSource: CloudSource,
    private val exceptionHandle: ExceptionHandle,
) : Repository {

    override suspend fun fetchCloud(): MyResult = try {
        cloudSource.fetchCloud()
    } catch (e: Exception) {
        exceptionHandle.handle(exception = e)
    }
}