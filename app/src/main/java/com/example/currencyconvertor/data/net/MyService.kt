package com.example.currencyconvertor.data.net

import com.example.currencyconvertor.data.model.DataCloud
import retrofit2.Response
import retrofit2.http.GET

interface MyService {

    companion object {
        const val BASE_URL = "https://www.cbr-xml-daily.ru/"
    }

    @GET("latest.js")
    suspend fun fetchCloud(): Response<DataCloud>
}

