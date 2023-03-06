package com.example.currencyconvertor.domain.model

import android.graphics.drawable.Drawable

data class DataDomain(
    var base: String = "",
    var date: String = "",
    var rate: List<Rate> = listOf(),
) {
    data class Rate(
        var rate: Double = 0.0,
        var name: String = "",
        var abbreviation: String = "",
        var flag: Drawable,
        var isChecked: Boolean = false
    )
}