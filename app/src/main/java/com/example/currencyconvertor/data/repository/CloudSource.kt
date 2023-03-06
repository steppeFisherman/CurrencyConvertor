package com.example.currencyconvertor.data.repository

import com.example.currencyconvertor.data.model.MapCloud
import com.example.currencyconvertor.data.net.CloudData
import com.example.currencyconvertor.domain.model.DataDomain
import com.example.currencyconvertor.domain.model.MyResult
import javax.inject.Inject

interface CloudSource {

    suspend fun fetchCloud(): MyResult

    class Base @Inject constructor(
        private val cloudData: CloudData,
        private val mapper: MapCloud
    ) : CloudSource {
        override suspend fun fetchCloud(): MyResult {
            val cloud = cloudData.fetchCloud()
            var domain = DataDomain()
            if (cloud.isSuccessful) {
                domain = mapper.toDomain(cloud.body()!!)
            }
            return MyResult.Success(domain)
        }
    }
}