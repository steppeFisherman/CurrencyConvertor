package com.example.currencyconvertor.domain

import com.example.currencyconvertor.domain.model.MyResult

interface Repository {
    suspend fun fetchCloud(): MyResult
}