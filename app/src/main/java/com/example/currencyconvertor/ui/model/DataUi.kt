package com.example.currencyconvertor.ui.model

import android.graphics.drawable.Drawable
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class DataUi(
    var base: String = "",
    var date: String = "",
    var rate: List<Rate> = listOf()
) : Parcelable {

    @Parcelize
    data class Rate(
        var rate: Double = 0.0,
        var name: String = "",
        var abbreviation: String = "",
        var flag: @RawValue Drawable,
        var isChecked: Boolean = false
    ) : Parcelable
}