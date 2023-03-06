package com.example.currencyconvertor.data.net

import com.example.currencyconvertor.data.model.DataCloud
import retrofit2.Response
import javax.inject.Inject

interface CloudData {

    suspend fun fetchCloud(): Response<DataCloud>

    class Base @Inject constructor(private val myService: MyService) : CloudData {
        override suspend fun fetchCloud(): Response<DataCloud> = myService.fetchCloud()
    }
}