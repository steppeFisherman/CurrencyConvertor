package com.example.currencyconvertor.data.model

import com.google.gson.annotations.SerializedName

data class DataCloud(
    @SerializedName("base")
    var base: String = "",
    @SerializedName("date")
    var date: String = "",
    @SerializedName("disclaimer")
    var disclaimer: String = "",
    @SerializedName("rates")
    var rates: Rates = Rates(),
    @SerializedName("timestamp")
    var timestamp: Int = 0
) {
    data class Rates(
        @SerializedName("AED")
        var aED: Double = 0.0,
        @SerializedName("AMD")
        var aMD: Double = 0.0,
        @SerializedName("AUD")
        var aUD: Double = 0.0,
        @SerializedName("AZN")
        var aZN: Double = 0.0,
        @SerializedName("BGN")
        var bGN: Double = 0.0,
        @SerializedName("BRL")
        var bRL: Double = 0.0,
        @SerializedName("BYN")
        var bYN: Double = 0.0,
        @SerializedName("CAD")
        var cAD: Double = 0.0,
        @SerializedName("CHF")
        var cHF: Double = 0.0,
        @SerializedName("CNY")
        var cNY: Double = 0.0,
        @SerializedName("CZK")
        var cZK: Double = 0.0,
        @SerializedName("DKK")
        var dKK: Double = 0.0,
        @SerializedName("EGP")
        var eGP: Double = 0.0,
        @SerializedName("EUR")
        var eUR: Double = 0.0,
        @SerializedName("GBP")
        var gBP: Double = 0.0,
        @SerializedName("GEL")
        var gEL: Double = 0.0,
        @SerializedName("HKD")
        var hKD: Double = 0.0,
        @SerializedName("HUF")
        var hUF: Double = 0.0,
        @SerializedName("IDR")
        var iDR: Double = 0.0,
        @SerializedName("INR")
        var iNR: Double = 0.0,
        @SerializedName("JPY")
        var jPY: Double = 0.0,
        @SerializedName("KGS")
        var kGS: Double = 0.0,
        @SerializedName("KRW")
        var kRW: Double = 0.0,
        @SerializedName("KZT")
        var kZT: Double = 0.0,
        @SerializedName("MDL")
        var mDL: Double = 0.0,
        @SerializedName("NOK")
        var nOK: Double = 0.0,
        @SerializedName("NZD")
        var nZD: Double = 0.0,
        @SerializedName("PLN")
        var pLN: Double = 0.0,
        @SerializedName("QAR")
        var qAR: Double = 0.0,
        @SerializedName("RON")
        var rON: Double = 0.0,
        @SerializedName("RSD")
        var rSD: Double = 0.0,
        @SerializedName("SEK")
        var sEK: Double = 0.0,
        @SerializedName("SGD")
        var sGD: Double = 0.0,
        @SerializedName("THB")
        var tHB: Double = 0.0,
        @SerializedName("TJS")
        var tJS: Double = 0.0,
        @SerializedName("TMT")
        var tMT: Double = 0.0,
        @SerializedName("TRY")
        var tRY: Double = 0.0,
        @SerializedName("UAH")
        var uAH: Double = 0.0,
        @SerializedName("USD")
        var uSD: Double = 0.0,
        @SerializedName("UZS")
        var uZS: Double = 0.0,
        @SerializedName("VND")
        var vND: Double = 0.0,
        @SerializedName("XDR")
        var xDR: Double = 0.0,
        @SerializedName("ZAR")
        var zAR: Double = 0.0
    )
}