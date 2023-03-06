package com.example.currencyconvertor.ui.model

import com.example.currencyconvertor.domain.model.DataDomain

interface MapDomainToUi {

    fun transform(domain: DataDomain): DataUi

    class Base : MapDomainToUi {
        override fun transform(domain: DataDomain): DataUi {

            val list = domain.rate
            val listRates = mutableListOf<DataUi.Rate>()

            list.forEach {
                val rate = DataUi.Rate(
                    it.rate,
                    it.name,
                    it.abbreviation,
                    it.flag,
                    it.isChecked
                )
                listRates.add(rate)
            }

            return DataUi(
                base = domain.base,
                date = domain.date,
                rate = listRates
            )
        }
    }
}